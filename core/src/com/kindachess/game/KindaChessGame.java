package com.kindachess.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kindachess.exceptions.KindaChessException;
import com.kindachess.game.games.AbstractGameType;
import com.kindachess.game.games.NormalGameType;
import com.kindachess.input.Controls;

public class KindaChessGame extends ApplicationAdapter {
    private AbstractGameType game;
    private SpriteBatch batch;
    private Controls controls;

    @Override
    public void create() {
        try {
            game = new NormalGameType();
        } catch (KindaChessException e) {
        }
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(Controls.getInstance());
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
