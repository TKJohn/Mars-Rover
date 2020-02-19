package com.thoughtworks.marsrover;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static com.thoughtworks.marsrover.Commands.forward;
import static com.thoughtworks.marsrover.Commands.nop;
import static com.thoughtworks.marsrover.Commands.turnLeft;
import static com.thoughtworks.marsrover.Commands.turnRight;
import static org.junit.Assert.assertEquals;

public class MovementCommandParserTest {
    private static final MovementCommandParser parser = new MovementCommandParser();

    @Test
    public void shouldReturnListOfCommandsGivenMovementCommandsString() {
        final String input = "MLRLMMRRLL";
        final List<Function<Rover, Rover>> result = parser.apply(input);

        final List<Function<Rover, Rover>> expectingCommands =
                Arrays.asList(forward, turnLeft, turnRight, turnLeft, forward, forward, turnRight, turnRight, turnLeft, turnLeft);

        assertEquals(expectingCommands, result);
    }

    @Test
    public void shouldReturnNopCommandGivenUnrecognizedMovementCommand() {
        final String input = "MAAL";
        final List<Function<Rover, Rover>> result = parser.apply(input);

        final List<Function<Rover, Rover>> expectingCommands = Arrays.asList(forward, nop, nop, turnLeft);

        assertEquals(expectingCommands, result);
    }

    @Test
    public void shouldReturnListOfNopCommandsGivenEmptyString() {
        final String input = "";
        final List<Function<Rover, Rover>> result = parser.apply(input);

        assertEquals(Collections.singletonList(nop), result);
    }
}
