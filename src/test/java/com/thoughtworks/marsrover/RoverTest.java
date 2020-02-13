package com.thoughtworks.marsrover;

import org.junit.Test;

import static com.thoughtworks.marsrover.Rover.forward;
import static com.thoughtworks.marsrover.Rover.turnLeft;
import static com.thoughtworks.marsrover.Rover.turnRight;
import static org.junit.Assert.assertEquals;

public class RoverTest {
    @Test
    public void yPlusWhenForwardGivenFacingNorth() {
        final Rover result = forward.apply(new Rover(1, 2, Direction.NORTH));
        assertEquals(new Rover(1, 3, Direction.NORTH), result);
    }

    @Test
    public void yMinusWhenForwardGivenFacingSouth() {
        final Rover result = forward.apply(new Rover(1, 2, Direction.SOUTH));
        assertEquals(new Rover(1, 1, Direction.SOUTH), result);
    }

    @Test
    public void xPlusWhenForwardGivenFacingEast() {
        final Rover result = forward.apply(new Rover(1, 2, Direction.EAST));
        assertEquals(new Rover(2, 2, Direction.EAST), result);
    }

    @Test
    public void xMinusWhenForwardGivenFacingWest() {
        final Rover result = forward.apply(new Rover(1, 2, Direction.WEST));
        assertEquals(new Rover(0, 2, Direction.WEST), result);
    }

    @Test
    public void FacingWestWhenTurnLeftGivenFacingNorth() {
        final Rover result = turnLeft.apply(new Rover(1, 2, Direction.NORTH));
        assertEquals(new Rover(1, 2, Direction.WEST), result);
    }

    @Test
    public void FacingSouthWhenTurnLeftGivenFacingWest() {
        final Rover result = turnLeft.apply(new Rover(1, 2, Direction.WEST));
        assertEquals(new Rover(1, 2, Direction.SOUTH), result);
    }

    @Test
    public void FacingEastWhenTurnLeftGivenFacingSouth() {
        final Rover result = turnLeft.apply(new Rover(1, 2, Direction.SOUTH));
        assertEquals(new Rover(1, 2, Direction.EAST), result);
    }

    @Test
    public void FacingNorthWhenTurnLeftGivenFacingEast() {
        final Rover result = turnLeft.apply(new Rover(1, 2, Direction.EAST));
        assertEquals(new Rover(1, 2, Direction.NORTH), result);
    }

    @Test
    public void FacingNorthWhenTurnRightGivenFacingWest() {
        final Rover result = turnRight.apply(new Rover(1, 2, Direction.WEST));
        assertEquals(new Rover(1, 2, Direction.NORTH), result);
    }

    @Test
    public void FacingWestWhenTurnRightGivenFacingSouth() {
        final Rover result = turnRight.apply(new Rover(1, 2, Direction.SOUTH));
        assertEquals(new Rover(1, 2, Direction.WEST), result);
    }

    @Test
    public void FacingSouthWhenTurnRightGivenFacingEast() {
        final Rover result = turnRight.apply(new Rover(1, 2, Direction.EAST));
        assertEquals(new Rover(1, 2, Direction.SOUTH), result);
    }

    @Test
    public void FacingEastWhenTurnRightGivenFacingNorth() {
        final Rover result = turnRight.apply(new Rover(1, 2, Direction.NORTH));
        assertEquals(new Rover(1, 2, Direction.EAST), result);
    }
}
