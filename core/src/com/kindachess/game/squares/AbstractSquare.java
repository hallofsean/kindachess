package com.kindachess.game.squares;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kindachess.game.boards.AbstractBoard;
import com.kindachess.exceptions.IncorrectSquareTypeException;
import com.kindachess.exceptions.InvalidBoardTypeException;
import com.kindachess.game.pieces.AbstractPiece;

import java.util.List;

public abstract class AbstractSquare {
    private AbstractBoard board;
    private boolean selected = false;
    private boolean destination = false;

    public AbstractSquare(AbstractBoard board) {
        this.board = board;
    }

    public AbstractBoard getBoard() {
        return board;
    }

    @Override
    public abstract int hashCode();

    public abstract void render(SpriteBatch batch, int x, int y);

    public boolean isObstructed() {
        return board.isObstructed(this);
    }

    public AbstractPiece getPiece() {
        return board.getPieceOnSquare(this);
    }

    public List<AbstractSquare> getNeighbours() throws InvalidBoardTypeException {
        try {
            return board.getNeighbours(this);
        } catch (IncorrectSquareTypeException e) {
            throw new InvalidBoardTypeException();
        }
    }

    public void select() {
        selected = true;
    }

    public void unselect() {
        selected = false;
    }

    /**
     * @return whether this square is selected
     */
    public boolean isSelected() {
        return selected;
    }

    public void setAsDestination() {
        destination = true;
    }

    public void unsetAsDestination() {
        destination = false;
    }

    /**
     * @return whether the currently selected piece can reach this square
     */
    public boolean isDestination() {
        return destination;
    }
}
