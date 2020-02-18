package com.thoughtworks.marsrover;

import io.vavr.control.Either;
import io.vavr.control.Try;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    private static final Map<String, Function<Rover, Rover>> commandMap = new HashMap<>();

    static {
        commandMap.put("M", Rover.forward);
        commandMap.put("L", Rover.turnLeft);
        commandMap.put("R", Rover.turnRight);
    }

    public static Either<ParsingError, List<Function<Rover, Rover>>> commands(final String input) {
        if (input.isEmpty()) {
            return Either.right(Collections.emptyList());
        }

        final Map<Boolean, List<Function<Rover, Rover>>> collect = Arrays.stream(input.split(""))
                .map(commandMap::get)
                .collect(Collectors.groupingBy(Objects::isNull));

        if (collect.get(true) != null) {
            return Either.left(new ParsingError("Unsupported command"));
        }

        return Either.right(collect.get(false));
    }
}
