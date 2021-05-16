package com.tennis;

public class TennisApp2 {
    public static void main( String[] args ) {
        InputHandler inputHandler = new InputHandler();
        Game game = new Game(inputHandler);
        game.startGame();
    }
}
