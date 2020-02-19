package com.thoughtworks.marsrover;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MovementCommandParser implements Function<String, List<Function<Rover, Rover>>> {
    private final Map<String, Function<Rover, Rover>> commandMap = new HashMap<>();

    public MovementCommandParser() {
        commandMap.put("M", Commands.forward);
        commandMap.put("L", Commands.turnLeft);
        commandMap.put("R", Commands.turnRight);
    }

    @Override
    public List<Function<Rover, Rover>> apply(final String input) {
        return Arrays.stream(input.split(""))
                .map(key -> commandMap.getOrDefault(key, Commands.nop))
                .collect(Collectors.toList());
    }
}
