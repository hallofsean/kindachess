package com.kindachess.game.moves.normalmoves;

import com.kindachess.game.exceptions.InvalidBoardTypeException;
import com.kindachess.game.moves.AbstractMoveScanner;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.pieces.normalpieces.PawnPiece;
import com.kindachess.game.squares.AbstractGridSquare;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.Move;
import com.kindachess.game.boards.NormalBoard;

import java.util.LinkedList;
import java.util.List;

public class EnPassantMoveScanner extends AbstractMoveScanner {
    @Override
    public List<Move> getMoves(AbstractPiece piece) throws InvalidBoardTypeException {
        List<Move> moves = new LinkedList<>();
        AbstractSquare startSquare = piece.getSquare();
        if (!(startSquare.getBoard() instanceof NormalBoard)) {
            throw new InvalidBoardTypeException();
        }

        SingleForwardMoveScanner forwardMove = new SingleForwardMoveScanner();

        if (forwardMove.getMoves(piece).size() > 0) {
            AbstractGridSquare start = (AbstractGridSquare) piece.getSquare();
            AbstractGridSquare forward = (AbstractGridSquare) forwardMove.getMoves(piece).get(0).getTo();
            AbstractGridSquare forwardLeft = forward.getLeft();
            AbstractGridSquare forwardRight = forward.getRight();
            AbstractGridSquare left = start.getLeft();
            AbstractGridSquare right = start.getRight();

            if (left != null && left.getPiece() != null && left.getPiece() instanceof PawnPiece) {
                Move lastMove = left.getPiece().getLastMove();
            }

            if (forwardRight != null && !forwardRight.isObstructed() && right.getPiece() != null
                    && right.getPiece().getTeam() != piece.getTeam()) {
                Move move = new Move(forwardRight.getBoard().getGame().getTurnCount(), startSquare, forwardRight);
                moves.add(move);
            }
        }

        return moves;
    }
}
