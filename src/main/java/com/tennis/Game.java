package com.tennis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {

    private InputHandler inputHandler;
    private GameState gameState;

    private static final Logger logger = LoggerFactory.getLogger(Game.class);


    public Game(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        this.gameState = new GameState();
    }

    public void start() {
        logger.info( "Starting Tennis Game between A and B");
        play();
    }

    private void play() {
        logger.info("Who won the next point player A or B?");
        inputHandler.getPointWinner();
    }


}
