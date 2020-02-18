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
    private static final Map<String, Function<Rover, Rover>> commandMap = new HashMap<>();

    static {
        commandMap.put("M", Commands.forward);
        commandMap.put("L", Commands.turnLeft);
        commandMap.put("R", Commands.turnRight);
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
