package com.kindachess.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kindachess.game.exceptions.KindaChessException;
import com.kindachess.game.games.AbstractGameType;
import com.kindachess.game.games.NormalGameType;

public class KindaChessGame extends ApplicationAdapter {
    private AbstractGameType game;
    private SpriteBatch batch;

    @Override
    public void create() {
        try {
            game = new NormalGameType();
        } catch (KindaChessException e) {}
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        batch.begin();
        game.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        game.dispose();
    }
}
