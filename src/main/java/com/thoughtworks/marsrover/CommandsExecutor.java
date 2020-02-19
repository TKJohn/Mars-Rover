package com.thoughtworks.marsrover;

import io.vavr.control.Either;

import java.util.List;
import java.util.function.Function;

public class CommandsExecutor implements Function<String, String> {
    @Override
    public String apply(final String input) {
        final String[] split = input.split(" ");
        if (split.length > 2) {
            return "Too much input commands";
        }

        final String init = split[0];
        final String movements = split.length == 2 ? split[1] : "";

        final Either<ParsingError, Rover> errorOrRover = new InitCommandParser().apply(init);
        final List<Function<Rover, Rover>> movementCommands = new MovementCommandParser().apply(movements);

        return errorOrRover
                .map(rover -> movementCommands.stream().reduce(Function.identity(), Function::andThen).apply(rover))
                .fold(ParsingError::getReason, Rover::toString);
    }
}
