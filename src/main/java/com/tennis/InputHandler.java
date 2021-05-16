package com.tennis;

import java.util.Scanner;

public class InputHandler {
    Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getPointWinner() {
        return scanner.nextLine();
    }
}
