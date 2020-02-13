package com.thoughtworks.marsrover;

import java.util.Objects;

public class Rover {
    private final int x;
    private final int y;
    private final Direction direction;

    public Rover(final int x, final int y, final Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Rover forward() {
        switch (this.direction) {
            case N:
                return new Rover(this.x, this.y + 1, this.direction);
            case S:
                return new Rover(this.x, this.y - 1, this.direction);
            case E:
                return new Rover(this.x + 1, this.y, this.direction);
            default:
                return new Rover(this.x - 1, this.y, this.direction);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Rover rover = (Rover) o;
        return x == rover.x &&
                y == rover.y &&
                direction == rover.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction);
    }
}
