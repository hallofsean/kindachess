package com.kindachess.game.games;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kindachess.game.TextureRegistry;
import com.kindachess.game.boards.NormalBoard;
import com.kindachess.game.exceptions.IncorrectSquareTypeException;;

public class NormalGameType extends AbstractGameType {
    private NormalBoard board;

    public NormalGameType() throws IncorrectSquareTypeException {
        board = new NormalBoard(this);
    }

    @Override
    public void render(SpriteBatch batch) {
        board.render(batch);
    }

    @Override
    public void dispose() {
        TextureRegistry.getInstance().dispose();
    }
}
