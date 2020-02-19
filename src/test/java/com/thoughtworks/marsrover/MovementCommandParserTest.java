package com.thoughtworks.marsrover;

import org.junit.Test;

import java.util.function.Function;

import static com.thoughtworks.marsrover.Commands.forward;
import static com.thoughtworks.marsrover.Commands.nop;
import static com.thoughtworks.marsrover.Commands.turnLeft;
import static com.thoughtworks.marsrover.Commands.turnRight;
import static org.junit.Assert.assertEquals;

public class MovementCommandParserTest {
    private static final MovementCommandParser parser = new MovementCommandParser();

    @Test
    public void shouldReturnForwardCommandGivenMCommandString() {
        final String input = "M";
        final Function<Rover, Rover> result = parser.apply(input);

        assertEquals(forward, result);
    }

    @Test
    public void shouldReturnTurnLeftCommandGivenLCommandString() {
        final String input = "L";
        final Function<Rover, Rover> result = parser.apply(input);

        assertEquals(turnLeft, result);
    }

    @Test
    public void shouldReturnTurnRightCommandGivenRCommandString() {
        final String input = "R";
        final Function<Rover, Rover> result = parser.apply(input);

        assertEquals(turnRight, result);
    }

    @Test
    public void shouldReturnNopCommandGivenUnrecognizedCommandString() {
        final String input = "";
        final Function<Rover, Rover> result = parser.apply(input);

        assertEquals(nop, result);
    }
}
