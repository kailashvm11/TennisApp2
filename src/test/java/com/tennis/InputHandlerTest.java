package com.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputHandlerTest {

    Scanner scanner;

    @BeforeEach
    public void restoreSystemInput() {
        scanner = new Scanner("A\n");
    }

    @Test
    public void shouldTakeUserInput() {
        InputHandler inputOutput= new InputHandler(scanner);
        assertEquals("A", inputOutput.getPointWinner());
    }

}
