package com.tennis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {

    InputHandler inputHandler;
    private static final Logger logger = LoggerFactory.getLogger(Game.class);


    public Game(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void startGame() {
        logger.info( "Starting Tennis Game between A and B");
        play();
    }

    private void play() {
        logger.info("Who won the next point player A or B?");
        inputHandler.getPointWinner();
    }


}
