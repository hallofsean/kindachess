package com.kindachess.game.games;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractGameType {
    private int turnCount = 0;

    public int getTurnCount() {
        return turnCount;
    }

    public void nextTurn() {
        turnCount++;
    }

    public abstract void render(SpriteBatch batch);
    
    public abstract void dispose();
}
