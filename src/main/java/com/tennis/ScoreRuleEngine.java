package com.tennis;

import java.util.HashMap;
import java.util.Map;

public class ScoreRuleEngine {

    private final Map<Score, Score> scoreMap;

    public ScoreRuleEngine() {
        scoreMap = new HashMap<>();
        scoreMap.put(Score.ZERO, Score.FIFTEEN);
        scoreMap.put(Score.FIFTEEN, Score.THIRTY);
        scoreMap.put(Score.THIRTY, Score.FORTY);
        scoreMap.put(Score.FORTY, Score.ADVANTAGE);
        scoreMap.put(Score.ADVANTAGE, Score.WIN);
    }

    public GameState getNextGameState(boolean isPointWinnerA, GameState gameState) {
        Score currentScore = isPointWinnerA ? gameState.getPlayerAScore() : gameState.getPlayerBScore();
        if (currentScore == Score.FORTY) {
            return getNextStateForForty(isPointWinnerA, gameState);
        }
        return getNextStateHashmap(isPointWinnerA, gameState);
    }

    private GameState getNextStateForForty(boolean isPointWinnerA, GameState gameState) {
        if (gameState.isDeuce()) {
            return getNextStateHashmap(isPointWinnerA, gameState);
        }
        if (gameState.isPlayerOnAdvantage()) {
            return new GameState(Score.FORTY, Score.FORTY);
        }
        return getNextStateForFortyToWin(isPointWinnerA, gameState);
    }


    private GameState getNextStateHashmap(boolean isPointWinnerA, GameState gameState) {
        Score nextScore;
        if(isPointWinnerA) {
            nextScore = scoreMap.get(gameState.getPlayerAScore());
            return new GameState(nextScore, gameState.getPlayerBScore());
        }
        nextScore = scoreMap.get(gameState.getPlayerBScore());
        return new GameState(gameState.getPlayerAScore(), nextScore);
    }

    private GameState getNextStateForFortyToWin(boolean isPointWinnerA, GameState gameState) {
        if(isPointWinnerA) {
            return new GameState(Score.WIN, gameState.getPlayerBScore());
        }
        return new GameState(gameState.getPlayerAScore(), Score.WIN);
    }
}
