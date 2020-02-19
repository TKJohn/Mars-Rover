package com.thoughtworks.marsrover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandsExecutorTest {
    private final CommandsExecutor executor = new CommandsExecutor();

    @Test
    public void shouldReportRoverFinalStateGivenCommandsString() {
        final String input = "0,0,N MLMRMMRM";
        final String result = executor.apply(input);

        assertEquals("Rover{x=0, y=3, facing=EAST}", result);
    }

    @Test
    public void shouldReportRoverFinalStateGivenNoMovementCommand() {
        final String input = "0,0,N";
        final String result = executor.apply(input);

        assertEquals("Rover{x=0, y=0, facing=NORTH}", result);
    }

    @Test
    public void shouldReportErrorGivenInvalidInitCommand() {
        final String input = "A,0,N MLMRMMRM";
        final String result = executor.apply(input);

        assertEquals("X should be int", result);
    }

    @Test
    public void shouldReportFinalStateGivenInvalidMovementCommand() {
        final String input = "1,0,N MXYZLMRMMRM";
        final String result = executor.apply(input);

        assertEquals("Rover{x=1, y=3, facing=EAST}", result);
    }

    @Test
    public void shouldReportErrorGivenInputStringWithMultipleSections() {
        final String input = "1,0,N MMRMMRM 1,0,S";
        final String result = executor.apply(input);

        assertEquals("Too much input commands", result);
    }
}
