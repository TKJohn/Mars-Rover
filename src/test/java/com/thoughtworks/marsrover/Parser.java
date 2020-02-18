package com.thoughtworks.marsrover;

import io.vavr.control.Either;
import io.vavr.control.Try;

public class Parser {
    public static Either<ParsingError, Rover> init(final String input) {
        final String[] split = input.split(",");
        if (split.length < 3) return Either.left(new ParsingError("Init too less"));
        if (split.length > 3) return Either.left(new ParsingError("Init too more"));

        final Either<ParsingError, Integer> errorOrX = Try.of(() -> Integer.parseInt(split[0]))
                .toEither(() -> new ParsingError("X should be int"));
        final Either<ParsingError, Integer> errorOrY = Try.of(() -> Integer.parseInt(split[1]))
                .toEither(() -> new ParsingError("Y should be int"));
        final Either<ParsingError, Direction> errorOrFacing = Direction.valueOfAbbr(split[2])
                .map(Either::<ParsingError, Direction>right)
                .orElseGet(() -> Either.left(new ParsingError("Direction must be either N, E, S or W")));

        return errorOrX.flatMap(
                x -> errorOrY.flatMap(
                        y -> errorOrFacing.flatMap(
                                facing -> Either.right(new Rover(x, y, facing)))));
    }
}
