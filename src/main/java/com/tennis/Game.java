package com.tennis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {

    private InputHandler inputHandler;
    private GameState gameState;
    private ScoreRuleEngine scoreRuleEngine;

    private static final Logger logger = LoggerFactory.getLogger(Game.class);


    public Game(InputHandler inputHandler) {

        this.inputHandler = inputHandler;
        this.gameState = new GameState();
        this.scoreRuleEngine = new ScoreRuleEngine();

    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void start() {
        logger.info( "Starting Tennis Game between A and B");
        play();
    }

    private void play() {
        logger.info("Who won the next point player A or B?");
        String pointWinner = inputHandler.getPointWinner();
        boolean isPointWinnerA = isPointWinnerA(pointWinner);
        setGameState(scoreRuleEngine.getNextGameState(isPointWinnerA, gameState));
    }

    private boolean isPointWinnerA(String pointWinner) {
        return pointWinner.equals("A");
    }

}
