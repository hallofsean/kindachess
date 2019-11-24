package com.kindachess.game.squares;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kindachess.game.TextureRegistry;
import com.kindachess.game.boards.AbstractBoard;
import com.kindachess.game.exceptions.IncorrectSquareTypeException;
import com.badlogic.gdx.graphics.Texture;

public class NormalSquare extends AbstractGridSquare {
    private static final int SIZE = 50;

    public NormalSquare(AbstractBoard board, int x, int y) throws IncorrectSquareTypeException {
        super(board, x, y);
    }

    @Override
    public void render(SpriteBatch batch, int x, int y) {
        Texture texture;
        if ((x+y)%2 == 0) {
            texture = TextureRegistry.getInstance().getTexture("WSquare");
        } else {
            texture = TextureRegistry.getInstance().getTexture("BSquare");
        }
        batch.draw(texture, x*SIZE, y*SIZE, SIZE, SIZE);
    }
}
