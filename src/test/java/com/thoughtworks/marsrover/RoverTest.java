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
}
