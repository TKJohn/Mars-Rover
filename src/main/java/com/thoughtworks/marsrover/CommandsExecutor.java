package com.thoughtworks.marsrover;

import io.vavr.control.Either;

import java.util.List;
import java.util.function.Function;

public class CommandsExecutor implements Function<String, String> {
    @Override
    public String apply(final String input) {
        final String[] split = input.split(" ");
        final String init = split[0];
        final String movements = split[1];

        final Either<ParsingError, Rover> errorOrRover = new InitCommandParser().apply(init);
        final Either<ParsingError, List<Function<Rover, Rover>>> errorOrMovements = new MovementCommandParser().apply(movements);

        return errorOrRover.flatMap(
                rover -> errorOrMovements
                        .map(movementsList -> movementsList.stream().reduce(Function.identity(), Function::andThen))
                        .map(composedMovements -> composedMovements.apply(rover)))
                .fold(ParsingError::getReason, Rover::toString);
    }
}
