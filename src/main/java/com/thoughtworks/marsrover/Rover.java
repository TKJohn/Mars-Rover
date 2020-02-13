package com.thoughtworks.marsrover;

import java.util.Objects;

public class Rover {
    private final int x;
    private final int y;
    private final Direction facing;

    public Rover(final int x, final int y, final Direction facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public Rover forward() {
        switch (this.facing) {
            case NORTH:
                return new Rover(this.x, this.y + 1, this.facing);
            case SOUTH:
                return new Rover(this.x, this.y - 1, this.facing);
            case EAST:
                return new Rover(this.x + 1, this.y, this.facing);
            default:
                return new Rover(this.x - 1, this.y, this.facing);
        }
    }

    public Rover turnLeft() {
        switch (this.facing) {
            case NORTH:
                return new Rover(this.x, this.y, Direction.WEST);
            case WEST:
                return new Rover(this.x, this.y, Direction.SOUTH);
            case SOUTH:
                return new Rover(this.x, this.y, Direction.EAST);
            default:
                return new Rover(this.x, this.y, Direction.NORTH);
        }
    }

    public Rover turnRight() {
        switch (this.facing) {
            case NORTH:
                return new Rover(this.x, this.y, Direction.EAST);
            case WEST:
                return new Rover(this.x, this.y, Direction.NORTH);
            case SOUTH:
                return new Rover(this.x, this.y, Direction.WEST);
            default:
                return new Rover(this.x, this.y, Direction.SOUTH);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Rover rover = (Rover) o;
        return x == rover.x &&
                y == rover.y &&
                facing == rover.facing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, facing);
    }
}
