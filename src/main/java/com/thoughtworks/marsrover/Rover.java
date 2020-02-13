package com.thoughtworks.marsrover;

import java.util.Objects;
import java.util.function.Function;

public class Rover {
    private final int x;
    private final int y;
    private final Direction facing;

    public Rover(final int x, final int y, final Direction facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public static Function<Rover, Rover> forward = rover -> {
        switch (rover.getFacing()) {
            case NORTH:
                return new Rover(rover.getX(), rover.getY() + 1, rover.getFacing());
            case SOUTH:
                return new Rover(rover.getX(), rover.getY() - 1, rover.getFacing());
            case EAST:
                return new Rover(rover.getX() + 1, rover.getY(), rover.getFacing());
            default:
                return new Rover(rover.getX() - 1, rover.getY(), rover.getFacing());
        }
    };

    public static Function<Rover, Rover> turnLeft = rover -> new Rover(rover.getX(), rover.getY(), rover.getFacing().left());

    public static Function<Rover, Rover> turnRight = rover -> new Rover(rover.getX(), rover.getY(), rover.getFacing().right());

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getFacing() {
        return this.facing;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Rover rover = (Rover) o;
        return x == rover.getX() &&
                y == rover.getY() &&
                facing == rover.getFacing();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y, this.facing);
    }
}
