package com.tennis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputHandlerTest {

    @AfterEach
    public void restoreSystemInput() {
        System.setIn(System.in);
    }

    @Test
    public void shouldTakeUserInput() {
        String input = "B";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputHandler inputOutput= new InputHandler();
        assertEquals("B", inputOutput.getPointWinner());
    }

}
