package com.thoughtworks.marsrover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {
    @Test
    public void yPlusWhenForwardGivenFacingNorth() {
        final Rover result = new Rover(1, 2, Direction.NORTH).forward();
        assertEquals(new Rover(1, 3, Direction.NORTH), result);
    }

    @Test
    public void yMinusWhenForwardGivenFacingSouth() {
        final Rover result = new Rover(1, 2, Direction.SOUTH).forward();
        assertEquals(new Rover(1, 1, Direction.SOUTH), result);
    }

    @Test
    public void xPlusWhenForwardGivenFacingEast() {
        final Rover result = new Rover(1, 2, Direction.EAST).forward();
        assertEquals(new Rover(2, 2, Direction.EAST), result);
    }

    @Test
    public void xMinusWhenForwardGivenFacingWest() {
        final Rover result = new Rover(1, 2, Direction.WEST).forward();
        assertEquals(new Rover(0, 2, Direction.WEST), result);
    }

    @Test
    public void FacingWestWhenTurnLeftGivenFacingNorth() {
        final Rover result = new Rover(1, 2, Direction.NORTH).turnLeft();
        assertEquals(new Rover(1, 2, Direction.WEST), result);
    }

    @Test
    public void FacingSouthWhenTurnLeftGivenFacingWest() {
        final Rover result = new Rover(1, 2, Direction.WEST).turnLeft();
        assertEquals(new Rover(1, 2, Direction.SOUTH), result);
    }

    @Test
    public void FacingEastWhenTurnLeftGivenFacingSouth() {
        final Rover result = new Rover(1, 2, Direction.SOUTH).turnLeft();
        assertEquals(new Rover(1, 2, Direction.EAST), result);
    }

    @Test
    public void FacingNorthWhenTurnLeftGivenFacingEast() {
        final Rover result = new Rover(1, 2, Direction.EAST).turnLeft();
        assertEquals(new Rover(1, 2, Direction.NORTH), result);
    }

    @Test
    public void FacingNorthWhenTurnRightGivenFacingWest() {
        final Rover result = new Rover(1, 2, Direction.WEST).turnRight();
        assertEquals(new Rover(1, 2, Direction.NORTH), result);
    }

    @Test
    public void FacingWestWhenTurnRightGivenFacingSouth() {
        final Rover result = new Rover(1, 2, Direction.SOUTH).turnRight();
        assertEquals(new Rover(1, 2, Direction.WEST), result);
    }

    @Test
    public void FacingSouthWhenTurnRightGivenFacingEast() {
        final Rover result = new Rover(1, 2, Direction.EAST).turnRight();
        assertEquals(new Rover(1, 2, Direction.SOUTH), result);
    }

    @Test
    public void FacingEastWhenTurnRightGivenFacingNorth() {
        final Rover result = new Rover(1, 2, Direction.NORTH).turnRight();
        assertEquals(new Rover(1, 2, Direction.EAST), result);
    }
}
