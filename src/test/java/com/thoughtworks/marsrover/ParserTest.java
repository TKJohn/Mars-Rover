package com.thoughtworks.marsrover;

import io.vavr.control.Either;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    @Test
    public void shouldReturnRoverGivenInitString() {
        final String input = "15,-20,E";
        final Either<ParsingError, Rover> result = Parser.init(input);

        assertEquals(Either.right(new Rover(15, -20, Direction.EAST)), result);
    }

    @Test
    public void shouldReturnErrorGivenLessThanThreeParts() {
        final String input = "15,E";
        final Either<ParsingError, Rover> result = Parser.init(input);

        assertEquals(Either.left(new ParsingError("Init too less")), result);
    }

    @Test
    public void shouldReturnErrorGivenMoreThanThreeParts() {
        final String input = "15,E,13,4";
        final Either<ParsingError, Rover> result = Parser.init(input);

        assertEquals(Either.left(new ParsingError("Init too more")), result);
    }

    @Test
    public void shouldReturnErrorGivenFirstPartNotInt() {
        final String input = "X,4,E";
        final Either<ParsingError, Rover> result = Parser.init(input);

        assertEquals(Either.left(new ParsingError("X should be int")), result);
    }

    @Test
    public void shouldReturnErrorGivenSecondPartNotInt() {
        final String input = "3,E,N";
        final Either<ParsingError, Rover> result = Parser.init(input);

        assertEquals(Either.left(new ParsingError("Y should be int")), result);
    }

    @Test
    public void shouldReturnErrorGivenThirdPartNotAbbrOfDirection() {
        final String input = "3,5,A";
        final Either<ParsingError, Rover> result = Parser.init(input);

        assertEquals(Either.left(new ParsingError("Direction must be either N, E, S or W")), result);
    }
}
