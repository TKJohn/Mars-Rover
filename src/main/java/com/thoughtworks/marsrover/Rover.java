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
