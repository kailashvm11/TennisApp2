package com.tennis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class InputHandler {
    Scanner scanner;
    private static final Logger logger = LoggerFactory.getLogger(InputHandler.class);

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public String getPointWinner() {
        logger.info("Who won the next point player A or B?");
        return scanner.nextLine();
    }
}
