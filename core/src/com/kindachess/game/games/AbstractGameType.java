package com.kindachess.game.games;

public abstract class AbstractGameType {
    private int turnCount = 0;

    public int getTurnCount() {
        return turnCount;
    }

    public void nextTurn() {
        turnCount++;
    }
}
