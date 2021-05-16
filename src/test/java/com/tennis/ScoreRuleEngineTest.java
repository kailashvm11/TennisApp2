package com.tennis;

import org.junit.jupiter.api.Test;

import static com.tennis.Score.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreRuleEngineTest {

    ScoreRuleEngine scoreRuleEngine = new ScoreRuleEngine();

    @Test
    public void shouldBeAdvantageForPlayerA()
    {
        GameState existingGameState = new GameState(FORTY, FORTY);
        GameState expectedGameState = new GameState(ADVANTAGE, FORTY);
        GameState actualGameState = scoreRuleEngine.getNextGameState(true, existingGameState);
        assertEquals(expectedGameState,actualGameState);
    }

    @Test
    public void shouldBeAdvantageForPlayerB()
    {
        GameState existingGameState = new GameState(FORTY, FORTY);
        GameState expectedGameState = new GameState(FORTY, ADVANTAGE);
        GameState actualGameState = scoreRuleEngine.getNextGameState(false, existingGameState);
        assertEquals(expectedGameState,actualGameState);
    }
    @Test
    public void shouldBeDeuceForPlayerAWithAdvantage()
    {
        GameState existingGameState = new GameState(ADVANTAGE, FORTY);
        GameState expectedGameState = new GameState(FORTY, FORTY);
        GameState actualGameState = scoreRuleEngine.getNextGameState(false, existingGameState);
        assertEquals(expectedGameState,actualGameState);
    }

    @Test
    public void shouldBeDeuceForPlayerBWithAdvantage()
    {
        GameState existingGameState = new GameState(FORTY, ADVANTAGE);
        GameState expectedGameState = new GameState(FORTY, FORTY);
        GameState actualGameState = scoreRuleEngine.getNextGameState(true, existingGameState);
        assertEquals(expectedGameState,actualGameState);
    }
    @Test
    public void shouldBeWinForPlayerAWithAdvantage()
    {
        GameState existingGameState = new GameState(ADVANTAGE, FORTY);
        GameState expectedGameState = new GameState(WIN, FORTY);
        GameState actualGameState = scoreRuleEngine.getNextGameState(true, existingGameState);
        assertEquals(expectedGameState,actualGameState);
    }

    @Test
    public void shouldBeWinForPlayerBWithAdvantage()
    {
        GameState existingGameState = new GameState(FORTY, ADVANTAGE);
        GameState expectedGameState = new GameState(FORTY, WIN);
        GameState actualGameState = scoreRuleEngine.getNextGameState(false, existingGameState);
        assertEquals(expectedGameState,actualGameState);
    }

    @Test
    public void shouldBeWinForPlayerAWithForty()
    {
        GameState existingGameState = new GameState(FORTY, ZERO);
        GameState expectedGameState = new GameState(WIN, ZERO);
        GameState actualGameState = scoreRuleEngine.getNextGameState(true, existingGameState);
        assertEquals(expectedGameState,actualGameState);
    }

    @Test
    public void shouldBeWinForPlayerBWithForty()
    {
        GameState existingGameState = new GameState(ZERO, FORTY);
        GameState expectedGameState = new GameState(ZERO, WIN);
        GameState actualGameState = scoreRuleEngine.getNextGameState(false, existingGameState);
        assertEquals(expectedGameState,actualGameState);
    }

    @Test
    public void shouldBeFifteenForPlayerAWithZero()
    {
        GameState existingGameState = new GameState(ZERO, ZERO);
        GameState expectedGameState = new GameState(FIFTEEN, ZERO);
        GameState actualGameState = scoreRuleEngine.getNextGameState(true, existingGameState);
        assertEquals(expectedGameState,actualGameState);
    }

    @Test
    public void shouldBeThirtyForPlayerBWithFifteen()
    {
        GameState existingGameState = new GameState(FIFTEEN, FIFTEEN);
        GameState expectedGameState = new GameState(FIFTEEN, THIRTY);
        GameState actualGameState = scoreRuleEngine.getNextGameState(false, existingGameState);
        assertEquals(expectedGameState,actualGameState);
    }

    @Test
    public void shouldBeFortyForPlayerAWithThirty()
    {
        GameState existingGameState = new GameState(THIRTY, FIFTEEN);
        GameState expectedGameState = new GameState(FORTY, FIFTEEN);
        GameState actualGameState = scoreRuleEngine.getNextGameState(true, existingGameState);
        assertEquals(expectedGameState,actualGameState);
    }
}
