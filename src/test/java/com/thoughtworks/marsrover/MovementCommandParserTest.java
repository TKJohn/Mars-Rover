package com.thoughtworks.marsrover;

import io.vavr.control.Either;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static com.thoughtworks.marsrover.Commands.forward;
import static com.thoughtworks.marsrover.Commands.turnLeft;
import static com.thoughtworks.marsrover.Commands.turnRight;
import static org.junit.Assert.assertEquals;

public class MovementCommandParserTest {
    private static final MovementCommandParser parser = new MovementCommandParser();

    @Test
    public void shouldReturnListOfCommandsGivenMovementCommandsString() {
        final String input = "MLRLMMRRLL";
        final Either<ParsingError, List<Function<Rover, Rover>>> result = parser.apply(input);

        final List<Function<Rover, Rover>> expectingCommands =
                Arrays.asList(forward, turnLeft, turnRight, turnLeft, forward, forward, turnRight, turnRight, turnLeft, turnLeft);

        assertEquals(Either.right(expectingCommands), result);
    }

    @Test
    public void shouldReturnEmptyListOfCommandsGivenEmptyString() {
        final String input = "";
        final Either<ParsingError, List<Function<Rover, Rover>>> result = parser.apply(input);

        assertEquals(Either.right(Collections.<Function<Rover, Rover>>emptyList()), result);
    }

    @Test
    public void shouldReturnErrorGivenUnrecognizedMovementCommand() {
        final String input = "A";
        final Either<ParsingError, List<Function<Rover, Rover>>> result = parser.apply(input);

        assertEquals(Either.left(new ParsingError("Unsupported command")), result);
    }
}
