package com.kindachess.game.squares;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kindachess.game.TextureRegistry;
import com.kindachess.game.boards.AbstractBoard;
import com.kindachess.game.exceptions.IncorrectSquareTypeException;
import com.badlogic.gdx.graphics.Texture;

public class NormalSquare extends AbstractGridSquare {

    public NormalSquare(AbstractBoard board, int x, int y) throws IncorrectSquareTypeException {
        super(board, x, y);
    }

    @Override
    public void render(SpriteBatch batch, int x, int y, int size) {
        Texture texture;
        if ((x+y)%2 == 0) {
            texture = TextureRegistry.getInstance().getTexture("BSquare");
        } else {
            texture = TextureRegistry.getInstance().getTexture("WSquare");
        }
        batch.draw(texture, x*size, y*size, size, size);
    }
}
