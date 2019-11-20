package com.kindachess.game.moves.normalmoves;

import com.kindachess.game.boards.GridBoard;
import com.kindachess.game.exceptions.InvalidBoardTypeException;
import com.kindachess.game.moves.AbstractMoveScanner;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractGridSquare;
import com.kindachess.game.squares.AbstractSquare;

import java.util.LinkedList;
import java.util.List;

public class StraightMoveScanner extends AbstractMoveScanner {
    @Override
    public List<AbstractSquare> getMoves(AbstractPiece piece) throws InvalidBoardTypeException {
        AbstractSquare start = piece.getSquare();
        if (!(start.getBoard() instanceof GridBoard)) {
            throw new InvalidBoardTypeException();
        }
        List<AbstractSquare> moves = new LinkedList<>();
        moves.addAll(getUpMoves(start));
        moves.addAll(getDownMoves(start));
        moves.addAll(getLeftMoves(start));
        moves.addAll(getRightMoves(start));

        return moves;
    }

    private List<AbstractSquare> getUpMoves(AbstractSquare start) {
        List<AbstractSquare> moves = new LinkedList<>();
        AbstractGridSquare current = ((AbstractGridSquare) start).getUp();
        while (current != null && !current.isObstructed()) {
            moves.add(current);
            current = current.getUp();
        }
        return moves;
    }

    private List<AbstractSquare> getDownMoves(AbstractSquare start) {
        List<AbstractSquare> moves = new LinkedList<>();
        AbstractGridSquare current = ((AbstractGridSquare) start).getDown();
        while (current != null && !current.isObstructed()) {
            moves.add(current);
            current = current.getDown();
        }
        return moves;
    }

    private List<AbstractSquare> getLeftMoves(AbstractSquare start) {
        List<AbstractSquare> moves = new LinkedList<>();
        AbstractGridSquare current = ((AbstractGridSquare) start).getLeft();
        while (current != null && !current.isObstructed()) {
            moves.add(current);
            current = current.getLeft();
        }
        return moves;
    }

    private List<AbstractSquare> getRightMoves(AbstractSquare start) {
        List<AbstractSquare> moves = new LinkedList<>();
        AbstractGridSquare current = ((AbstractGridSquare) start).getRight();
        while (current != null && !current.isObstructed()) {
            moves.add(current);
            current = current.getRight();
        }
        return moves;
    }
}
