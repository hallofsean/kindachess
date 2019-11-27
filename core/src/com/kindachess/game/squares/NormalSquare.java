package com.kindachess.game.squares;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kindachess.game.TextureRegistry;
import com.kindachess.game.boards.AbstractBoard;
import com.kindachess.game.boards.GridBoard;
import com.kindachess.game.util.CoordinateConverter;
import com.kindachess.exceptions.IncorrectSquareTypeException;
import com.kindachess.exceptions.InvalidBoardTypeException;
import com.badlogic.gdx.graphics.Texture;
import com.kindachess.input.Controls;
import com.kindachess.input.LeftClickObserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NormalSquare extends AbstractGridSquare implements LeftClickObserver {
    private static Logger LOGGER = LoggerFactory.getLogger(NormalSquare.class);

    private int size;

    public NormalSquare(AbstractBoard board, int x, int y, int size) throws IncorrectSquareTypeException {
        super(board, x, y);
        this.size = size;
        Controls.getInstance().addLeftClickObserver(this);
    }

    @Override
    public void render(SpriteBatch batch, int x, int y) {
        Texture texture;
        if (isSelected()) {
            texture = TextureRegistry.getInstance().getTexture("SSquare");
        } else if (isDestination()) {
            texture = TextureRegistry.getInstance().getTexture("MSquare");
        } else if ((x + y) % 2 == 0) {
            texture = TextureRegistry.getInstance().getTexture("BSquare");
        } else {
            texture = TextureRegistry.getInstance().getTexture("WSquare");
        }
        batch.draw(texture, x * size, y * size, size, size);
    }

    

    @Override
    public void alertLeftClick(int screenX, int screenY) {
        int[] boardCoordinates = CoordinateConverter.screenToBoardCoordinates((GridBoard) getBoard(), screenX, screenY);
        if (boardCoordinates[0] == getX() && boardCoordinates[1] == getY()) {
            LOGGER.debug("Square at {}, {} selected", boardCoordinates[0], boardCoordinates[1]);
            if (getPiece() != null) {
                try {
                    getPiece().select();
                } catch (InvalidBoardTypeException e) {
                    // TODO handle exceptions
                }
                select();
            }
        } else {
            unselect();
        }
    } 
}
