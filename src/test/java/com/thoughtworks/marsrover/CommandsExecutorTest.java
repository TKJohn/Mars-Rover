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
}
