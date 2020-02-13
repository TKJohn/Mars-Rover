package com.thoughtworks.marsrover;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Direction {
    EAST(0),
    NORTH(90),
    WEST(180),
    SOUTH(270);

    private final int angle;
    private static final Map<Integer, Direction> angleLookupDirection = new HashMap<>();

    static {
        for (Direction direction : EnumSet.allOf(Direction.class)) {
            angleLookupDirection.put(direction.angle, direction);
        }
    }

    Direction(final int angle) {
        this.angle = angle;
    }

    public Direction left() {
        int leftAngle = (this.angle + 90) % 360;
        return angleLookupDirection.get(leftAngle);
    }

    public Direction right() {
        int rightAngle = (this.angle + 270) % 360;
        return angleLookupDirection.get(rightAngle);
    }
}
