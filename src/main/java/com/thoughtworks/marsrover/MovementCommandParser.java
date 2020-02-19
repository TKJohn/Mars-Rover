package com.thoughtworks.marsrover;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MovementCommandParser implements Function<String, Function<Rover, Rover>> {
    private final Map<String, Function<Rover, Rover>> commandMap = new HashMap<>();

    public MovementCommandParser() {
        commandMap.put("M", Commands.forward);
        commandMap.put("L", Commands.turnLeft);
        commandMap.put("R", Commands.turnRight);
    }

    @Override
    public Function<Rover, Rover> apply(final String input) {
        return commandMap.getOrDefault(input, Commands.nop);
    }
}
