package com.kindachess.game.squares;

import com.kindachess.game.boards.AbstractBoard;
import com.kindachess.game.exceptions.IncorrectSquareTypeException;
import com.kindachess.game.exceptions.InvalidBoardTypeException;
import com.kindachess.game.pieces.AbstractPiece;

import java.util.List;

public abstract class AbstractSquare {
    private AbstractBoard board;

    public AbstractSquare(AbstractBoard board) {
        this.board = board;
    }

    public AbstractBoard getBoard() {
        return board;
    }

    @Override
    public abstract int hashCode();

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
}
