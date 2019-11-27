package com.kindachess.game.moves.normalmoves;

import com.kindachess.game.boards.GridBoard;
import com.kindachess.exceptions.InvalidBoardTypeException;
import com.kindachess.game.moves.AbstractMoveScanner;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractGridSquare;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.KillMove;
import com.kindachess.game.util.Move;

import java.util.LinkedList;
import java.util.List;

public class DiagonalMoveScanner extends AbstractMoveScanner {
    @Override
    public List<Move> getMoves(AbstractPiece piece) throws InvalidBoardTypeException {
        AbstractSquare start = piece.getSquare();
        if (!(start.getBoard() instanceof GridBoard)) {
            throw new InvalidBoardTypeException();
        }
        List<Move> moves = new LinkedList<>();
        moves.addAll(getUpLeftMoves(start));
        moves.addAll(getUpRightMoves(start));
        moves.addAll(getDownLeftMoves(start));
        moves.addAll(getDownRightMoves(start));

        return moves;
    }

    private List<Move> getUpLeftMoves(AbstractSquare start) {
        List<Move> moves = new LinkedList<>();
        int turn = start.getBoard().getGameType().getTurnCount();

        AbstractGridSquare currentSquare = (AbstractGridSquare) start;
        currentSquare = currentSquare.getUp();
        if (currentSquare != null) {
            currentSquare = currentSquare.getLeft();
            while (currentSquare != null && !currentSquare.isObstructed()) {
                moves.add(new Move(turn, start, currentSquare));
                currentSquare = currentSquare.getUp();
                if (currentSquare != null) {
                    currentSquare.getLeft();
                }
            }
            if (currentSquare != null && currentSquare.getPiece() != null) {
                moves.add(new KillMove(turn, start, currentSquare, currentSquare.getPiece()));
            }
        }

        return moves;
    }

    private List<Move> getUpRightMoves(AbstractSquare start) {
        List<Move> moves = new LinkedList<>();
        int turn = start.getBoard().getGameType().getTurnCount();

        AbstractGridSquare currentSquare = (AbstractGridSquare) start;
        currentSquare = currentSquare.getUp();
        if (currentSquare != null) {
            currentSquare = currentSquare.getRight();
            while (currentSquare != null && !currentSquare.isObstructed()) {
                moves.add(new Move(turn, start, currentSquare));
                currentSquare = currentSquare.getUp();
                if (currentSquare != null) {
                    currentSquare.getRight();
                }
            }
            if (currentSquare != null && currentSquare.getPiece() != null) {
                moves.add(new KillMove(turn, start, currentSquare, currentSquare.getPiece()));
            }
        }

        return moves;
    }

    private List<Move> getDownLeftMoves(AbstractSquare start) {
        List<Move> moves = new LinkedList<>();
        int turn = start.getBoard().getGameType().getTurnCount();

        AbstractGridSquare currentSquare = (AbstractGridSquare) start;
        currentSquare = currentSquare.getDown();
        if (currentSquare != null) {
            currentSquare = currentSquare.getLeft();
            while (currentSquare != null && !currentSquare.isObstructed()) {
                moves.add(new Move(turn, start, currentSquare));
                currentSquare = currentSquare.getDown();
                if (currentSquare != null) {
                    currentSquare.getLeft();
                }
            }
            if (currentSquare != null && currentSquare.getPiece() != null) {
                moves.add(new KillMove(turn, start, currentSquare, currentSquare.getPiece()));
            }
        }

        return moves;
    }

    private List<Move> getDownRightMoves(AbstractSquare start) {
        List<Move> moves = new LinkedList<>();
        int turn = start.getBoard().getGameType().getTurnCount();

        AbstractGridSquare currentSquare = (AbstractGridSquare) start;
        currentSquare = currentSquare.getDown();
        if (currentSquare != null) {
            currentSquare = currentSquare.getRight();
            while (currentSquare != null && !currentSquare.isObstructed()) {
                moves.add(new Move(turn, start, currentSquare));
                currentSquare = currentSquare.getDown();
                if (currentSquare != null) {
                    currentSquare.getRight();
                }
            }
            if (currentSquare != null && currentSquare.getPiece() != null) {
                moves.add(new KillMove(turn, start, currentSquare, currentSquare.getPiece()));
            }
        }

        return moves;
    }
}
