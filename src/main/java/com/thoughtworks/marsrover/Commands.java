package com.thoughtworks.marsrover;

import java.util.function.Function;

public class Commands {
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

    public static Function<Rover, Rover> nop = Function.identity();
}
