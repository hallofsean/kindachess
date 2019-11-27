package com.kindachess.game.moves.normalmoves;

import com.kindachess.game.boards.GridBoard;
import com.kindachess.exceptions.InvalidBoardTypeException;
import com.kindachess.game.moves.AbstractMoveScanner;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractGridSquare;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.Move;

import java.util.LinkedList;
import java.util.List;

public class StraightMoveScanner extends AbstractMoveScanner {
    @Override
    public List<Move> getMoves(AbstractPiece piece) throws InvalidBoardTypeException {
        AbstractSquare start = piece.getSquare();
        if (!(start.getBoard() instanceof GridBoard)) {
            throw new InvalidBoardTypeException();
        }
        List<Move> moves = new LinkedList<>();
        moves.addAll(getUpMoves(start));
        moves.addAll(getDownMoves(start));
        moves.addAll(getLeftMoves(start));
        moves.addAll(getRightMoves(start));

        return moves;
    }

    private List<Move> getUpMoves(AbstractSquare start) {
        int turn = start.getBoard().getGameType().getTurnCount();
        List<Move> moves = new LinkedList<>();
        AbstractGridSquare current = ((AbstractGridSquare) start).getUp();
        while (current != null && !current.isObstructed()) {
            moves.add(new Move(turn, start, current));
            current = current.getUp();
        }
        return moves;
    }

    private List<Move> getDownMoves(AbstractSquare start) {
        int turn = start.getBoard().getGameType().getTurnCount();
        List<Move> moves = new LinkedList<>();
        AbstractGridSquare current = ((AbstractGridSquare) start).getDown();
        while (current != null && !current.isObstructed()) {
            moves.add(new Move(turn, start, current));
            current = current.getDown();
        }
        return moves;
    }

    private List<Move> getLeftMoves(AbstractSquare start) {
        int turn = start.getBoard().getGameType().getTurnCount();
        List<Move> moves = new LinkedList<>();
        AbstractGridSquare current = ((AbstractGridSquare) start).getLeft();
        while (current != null && !current.isObstructed()) {
            moves.add(new Move(turn, start, current));
            current = current.getLeft();
        }
        return moves;
    }

    private List<Move> getRightMoves(AbstractSquare start) {
        int turn = start.getBoard().getGameType().getTurnCount();
        List<Move> moves = new LinkedList<>();
        AbstractGridSquare current = ((AbstractGridSquare) start).getRight();
        while (current != null && !current.isObstructed()) {
            moves.add(new Move(turn, start, current));
            current = current.getRight();
        }
        return moves;
    }
}
