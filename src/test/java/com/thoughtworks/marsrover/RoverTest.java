package com.thoughtworks.marsrover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {
    @Test
    public void yPlusWhenForwardGivenDirectionN() {
        final Rover result = new Rover(1, 2, Direction.N).forward();
        assertEquals(new Rover(1, 3, Direction.N), result);
    }

    @Test
    public void yMinusWhenForwardGivenDirectionS() {
        final Rover result = new Rover(1, 2, Direction.S).forward();
        assertEquals(new Rover(1, 1, Direction.S), result);
    }

    @Test
    public void xPlusWhenForwardGivenDirectionE() {
        final Rover result = new Rover(1, 2, Direction.E).forward();
        assertEquals(new Rover(2, 2, Direction.E), result);
    }

    @Test
    public void xMinusWhenForwardGivenDirectionW() {
        final Rover result = new Rover(1, 2, Direction.W).forward();
        assertEquals(new Rover(0, 2, Direction.W), result);
    }

    @Test
    public void directionWWhenLeftGivenDirectionN() {
        final Rover result = new Rover(1, 2, Direction.N).left();
        assertEquals(new Rover(1, 2, Direction.W), result);
    }

    @Test
    public void directionSWhenLeftGivenDirectionW() {
        final Rover result = new Rover(1, 2, Direction.W).left();
        assertEquals(new Rover(1, 2, Direction.S), result);
    }

    @Test
    public void directionEWhenLeftGivenDirectionS() {
        final Rover result = new Rover(1, 2, Direction.S).left();
        assertEquals(new Rover(1, 2, Direction.E), result);
    }

    @Test
    public void directionNWhenLeftGivenDirectionE() {
        final Rover result = new Rover(1, 2, Direction.E).left();
        assertEquals(new Rover(1, 2, Direction.N), result);
    }

    @Test
    public void directionNWhenLeftGivenDirectionW() {
        final Rover result = new Rover(1, 2, Direction.W).right();
        assertEquals(new Rover(1, 2, Direction.N), result);
    }

    @Test
    public void directionWWhenLeftGivenDirectionS() {
        final Rover result = new Rover(1, 2, Direction.S).right();
        assertEquals(new Rover(1, 2, Direction.W), result);
    }

    @Test
    public void directionSWhenLeftGivenDirectionE() {
        final Rover result = new Rover(1, 2, Direction.E).right();
        assertEquals(new Rover(1, 2, Direction.S), result);
    }

    @Test
    public void directionEWhenLeftGivenDirectionN() {
        final Rover result = new Rover(1, 2, Direction.N).right();
        assertEquals(new Rover(1, 2, Direction.E), result);
    }
}
