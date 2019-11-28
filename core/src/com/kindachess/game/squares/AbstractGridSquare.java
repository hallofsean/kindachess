package com.kindachess.game.squares;

import com.kindachess.game.boards.AbstractBoard;
import com.kindachess.game.boards.AbstractGridBoard;
import com.kindachess.exceptions.IncorrectSquareTypeException;

public abstract class AbstractGridSquare extends AbstractSquare {
    private int x, y;

    public AbstractGridSquare(AbstractBoard board, int x, int y) throws IncorrectSquareTypeException {
        super(board);
        if (!(board instanceof AbstractGridBoard)) {
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
        return ((AbstractGridBoard) getBoard()).getUp(this);
    }

    public AbstractGridSquare getDown() {
        return ((AbstractGridBoard) getBoard()).getDown(this);
    }

    public AbstractGridSquare getLeft() {
        return ((AbstractGridBoard) getBoard()).getLeft(this);
    }

    public AbstractGridSquare getRight() {
        return ((AbstractGridBoard) getBoard()).getRight(this);
    }
}
