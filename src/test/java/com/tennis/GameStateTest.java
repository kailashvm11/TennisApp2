package com.tennis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameStateTest {

    @Test
    public void shouldReturnDeuceFalse() {
        GameState gameState = new GameState(Score.FORTY, Score.ADVANTAGE);
        assertEquals(false, gameState.isDeuce());
    }

    @Test
    public void shouldReturnDeuceTrue() {
        GameState gameState = new GameState(Score.FORTY, Score.FORTY);
        assertEquals(true, gameState.isDeuce());
    }

    @Test
    public void shouldReturnInProgressTrue() {
        GameState gameState = new GameState(Score.FORTY, Score.ADVANTAGE);
        assertEquals(true, gameState.isInProgress());
    }

    @Test
    public void shouldReturnInProgressFalse() {
        GameState gameState = new GameState(Score.WIN, Score.ZERO);
        assertEquals(false, gameState.isInProgress());
    }
}
