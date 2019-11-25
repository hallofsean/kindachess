package com.kindachess.game.moves.normalmoves;

import com.kindachess.game.boards.GridBoard;
import com.kindachess.game.exceptions.InvalidBoardTypeException;
import com.kindachess.game.moves.AbstractMoveScanner;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractGridSquare;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.KillMove;
import com.kindachess.game.util.Move;

import java.util.LinkedList;
import java.util.List;

public class KnightMoveScanner extends AbstractMoveScanner {
    @Override
    public List<Move> getMoves(AbstractPiece piece) throws InvalidBoardTypeException {
        AbstractSquare start = piece.getSquare();
        if (!(start.getBoard() instanceof GridBoard)) {
            throw new InvalidBoardTypeException();
        }
        List<Move> moves = new LinkedList<>();

        moves.addAll(getUpMoves(start, piece));
        moves.addAll(getDownMoves(start, piece));
        moves.addAll(getLeftMoves(start, piece));
        moves.addAll(getRightMoves(start, piece));

        return moves;
    }

    private List<Move> getUpMoves(AbstractSquare start, AbstractPiece piece) {
        int turn = start.getBoard().getGame().getTurnCount();
        List<Move> moves = new LinkedList<>();
        AbstractGridSquare up = ((AbstractGridSquare) start).getUp().getUp();

        if (up.getLeft() != null) {
            if (!up.getLeft().isObstructed()) {
                moves.add(new Move(turn, start, up.getLeft()));
            } else if (up.getLeft().getPiece().getTeam() != piece.getTeam()) {
                moves.add(new KillMove(turn, start, up.getLeft(), up.getLeft().getPiece()));
            }
        }

        if (up.getRight() == null) {
            if (!up.getRight().isObstructed()) {
                moves.add(new Move(turn, start, up.getRight()));
            } else if (up.getRight().getPiece().getTeam() != piece.getTeam()) {
                moves.add(new KillMove(turn, start, up.getRight(), up.getRight().getPiece()));
            }
        }

        return moves;
    }

    private List<Move> getDownMoves(AbstractSquare start, AbstractPiece piece) {
        int turn = start.getBoard().getGame().getTurnCount();
        List<Move> moves = new LinkedList<>();
        AbstractGridSquare down = ((AbstractGridSquare) start).getDown().getDown();

        if (down.getLeft() == null) {
            if (!down.getLeft().isObstructed()) {
                moves.add(new Move(turn, start, down.getLeft()));
            } else if (down.getLeft().getPiece().getTeam() != piece.getTeam()) {
                moves.add(new KillMove(turn, start, down.getLeft(), down.getLeft().getPiece()));
            }
        }

        if (down.getRight() == null) {
            if (!down.getRight().isObstructed()) {
                moves.add(new Move(turn, start, down.getRight()));
            } else if (down.getRight().getPiece().getTeam() != piece.getTeam()) {
                moves.add(new KillMove(turn, start, down.getRight(), down.getRight().getPiece()));
            }
        }

        return moves;
    }

    private List<Move> getLeftMoves(AbstractSquare start, AbstractPiece piece) {
        int turn = start.getBoard().getGame().getTurnCount();
        List<Move> moves = new LinkedList<>();
        AbstractGridSquare left = ((AbstractGridSquare) start).getLeft().getLeft();

        if (left.getDown() == null) {
            if (!left.getDown().isObstructed()) {
                moves.add(new Move(turn, start, left.getDown()));
            } else if (left.getDown().getPiece().getTeam() != piece.getTeam()) {
                moves.add(new KillMove(turn, start, left.getDown(), left.getDown().getPiece()));
            }
        }

        if (left.getUp() == null) {
            if (!left.getUp().isObstructed()) {
                moves.add(new Move(turn, start, left.getUp()));
            } else if (left.getUp().getPiece().getTeam() != piece.getTeam()) {
                moves.add(new KillMove(turn, start, left.getUp(), left.getUp().getPiece()));
            }
        }

        return moves;
    }

    private List<Move> getRightMoves(AbstractSquare start, AbstractPiece piece) {
        int turn = start.getBoard().getGame().getTurnCount();
        List<Move> moves = new LinkedList<>();
        AbstractGridSquare right = ((AbstractGridSquare) start).getRight().getRight();

        if (right.getDown() == null) {
            if (!right.getDown().isObstructed()) {
                moves.add(new Move(turn, start, right.getDown()));
            } else if (right.getDown().getPiece().getTeam() != piece.getTeam()) {
                moves.add(new KillMove(turn, start, right.getDown(), right.getDown().getPiece()));
            }
        }

        if (right.getUp() == null) {
            if (!right.getUp().isObstructed()) {
                moves.add(new Move(turn, start, right.getUp()));
            } else if (right.getUp().getPiece().getTeam() != piece.getTeam()) {
                moves.add(new KillMove(turn, start, right.getUp(), right.getUp().getPiece()));
            }
        }

        return moves;
    }
}
