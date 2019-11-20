package com.kindachess.game.squares;

import com.kindachess.game.boards.AbstractBoard;
import com.kindachess.game.boards.GridBoard;
import com.kindachess.game.exceptions.IncorrectSquareTypeException;

public abstract class AbstractGridSquare extends AbstractSquare {
    private int x, y;

    public AbstractGridSquare(AbstractBoard board, int x, int y) throws IncorrectSquareTypeException {
        super(board);
        if (!(board instanceof GridBoard)) {
            throw new IncorrectSquareTypeException();
        }
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return 7 * x * y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public AbstractGridSquare getUp() {
        return ((GridBoard) getBoard()).getUp(this);
    }

    public AbstractGridSquare getDown() {
        return ((GridBoard) getBoard()).getDown(this);
    }

    public AbstractGridSquare getLeft() {
        return ((GridBoard) getBoard()).getLeft(this);
    }

    public AbstractGridSquare getRight() {
        return ((GridBoard) getBoard()).getRight(this);
    }
}
