package com.thoughtworks.marsrover;

import java.util.Arrays;
import java.util.function.Function;

public class CommandsExecutor implements Function<String, String> {

    private static final InitCommandParser initParser = new InitCommandParser();
    private static final MovementCommandParser movementParser = new MovementCommandParser();

    @Override
    public String apply(final String input) {
        final String[] split = input.split(" ");
        if (split.length > 2) {
            return "Too much input commands";
        }

        final String init = split[0];
        final String movements = split.length == 2 ? split[1] : "";

        return initParser.apply(init)
                .map(constructMovementCommand(movements))
                .getOrElseGet(ParsingError::getReason);
    }

    private Function<Rover, String> constructMovementCommand(final String movements) {
        return Arrays.stream(movements.split(""))
                .map(movementParser)
                .reduce(Function.identity(), Function::andThen)
                .andThen(Commands.report);
    }
}
