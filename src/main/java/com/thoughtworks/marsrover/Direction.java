package com.thoughtworks.marsrover;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Direction {
    EAST(0, "E"),
    NORTH(90, "N"),
    WEST(180, "W"),
    SOUTH(270, "S");

    private final int angle;
    private final String abbr;
    private static final Map<Integer, Direction> angleLookupDirection = new HashMap<>();
    private static final Map<String, Direction> abbrLookupDirection = new HashMap<>();

    static {
        for (Direction direction : EnumSet.allOf(Direction.class)) {
            angleLookupDirection.put(direction.angle, direction);
            abbrLookupDirection.put(direction.abbr, direction);
        }
    }

    Direction(final int angle, final String abbr) {
        this.angle = angle;
        this.abbr = abbr;
    }

    public Direction left() {
        int leftAngle = (this.angle + 90) % 360;
        return angleLookupDirection.get(leftAngle);
    }

    public Direction right() {
        int rightAngle = (this.angle + 270) % 360;
        return angleLookupDirection.get(rightAngle);
    }

    public static Optional<Direction> valueOfAbbr(String abbr) {
        return Optional.ofNullable(abbrLookupDirection.get(abbr));
    }
}
