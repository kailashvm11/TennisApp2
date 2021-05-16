package com.tennis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {

    private static final Logger logger = LoggerFactory.getLogger(Game.class);

    public Game() {
    }

    public void startGame() {
        logger.info( "Starting Tennis Game between A and B");
    }
}
