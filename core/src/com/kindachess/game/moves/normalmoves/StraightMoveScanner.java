package com.kindachess.game.moves.normalmoves;

import com.kindachess.game.boards.AbstractGridBoard;
import com.kindachess.exceptions.InvalidBoardTypeException;
import com.kindachess.game.moves.AbstractMoveScanner;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractGridSquare;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.KillMove;
import com.kindachess.game.util.Move;

import java.util.LinkedList;
import java.util.List;

public class StraightMoveScanner extends AbstractMoveScanner {
    @Override
    public List<Move> getMoves(AbstractPiece piece) throws InvalidBoardTypeException {
        AbstractSquare start = piece.getSquare();
        if (!(start.getBoard() instanceof AbstractGridBoard)) {
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

        if (current != null && current.isObstructed()) {
            if (current.getPiece() != null) {
                if (current.getPiece().getTeam() != start.getPiece().getTeam()) {
                    moves.add(new KillMove(turn, start, current, current.getPiece()));
                }
            }
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
        
        if (current != null && current.isObstructed()) {
            if (current.getPiece() != null) {
                if (current.getPiece().getTeam() != start.getPiece().getTeam()) {
                    moves.add(new KillMove(turn, start, current, current.getPiece()));
                }
            }
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

        if (current != null && current.isObstructed()) {
            if (current.getPiece() != null) {
                if (current.getPiece().getTeam() != start.getPiece().getTeam()) {
                    moves.add(new KillMove(turn, start, current, current.getPiece()));
                }
            }
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

        if (current != null && current.isObstructed()) {
            if (current.getPiece() != null) {
                if (current.getPiece().getTeam() != start.getPiece().getTeam()) {
                    moves.add(new KillMove(turn, start, current, current.getPiece()));
                }
            }
        }
        
        return moves;
    }
}
