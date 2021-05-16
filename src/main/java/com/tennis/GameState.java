package com.tennis;

import java.util.Objects;

import static com.tennis.Score.WIN;

public class GameState {


    private Score playerAScore;
    private Score playerBScore;

    public GameState() {
        this(Score.ZERO, Score.ZERO);
    }

    public GameState(Score playerAScore, Score playerBScore) {
        this.playerAScore = playerAScore;
        this.playerBScore = playerBScore;
    }

    public Score getPlayerAScore() {
        return playerAScore;
    }

    public void setPlayerAScore(Score playerAScore) {
        this.playerAScore = playerAScore;
    }

    public Score getPlayerBScore() {
        return playerBScore;
    }

    public void setPlayerBScore(Score playerBScore) {
        this.playerBScore = playerBScore;
    }

    public boolean isDeuce() {
        return this.playerAScore == Score.FORTY && this.playerBScore == Score.FORTY;
    }

    public boolean isInProgress() {
        return this.getPlayerAScore() != WIN && this.getPlayerBScore() != WIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameState gameState = (GameState) o;
        return getPlayerAScore() == gameState.getPlayerAScore() &&
                getPlayerBScore() == gameState.getPlayerBScore();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlayerAScore(), getPlayerBScore());
    }
}
