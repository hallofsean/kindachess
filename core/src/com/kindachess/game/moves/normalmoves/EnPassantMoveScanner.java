package com.kindachess.game.moves.normalmoves;

import com.kindachess.exceptions.InvalidBoardTypeException;
import com.kindachess.game.moves.AbstractMoveScanner;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.pieces.normalpieces.PawnPiece;
import com.kindachess.game.squares.AbstractGridSquare;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.KillMove;
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
        int turn = startSquare.getBoard().getGameType().getTurnCount();

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
                if (lastMove != null && lastMove.getFrom() == forwardLeft) {
                    moves.add(new KillMove(turn, startSquare, forwardLeft, left.getPiece()));
                }
            }

            if (right != null && right.getPiece() != null && right.getPiece() instanceof PawnPiece) {
                Move lastMove = right.getPiece().getLastMove();
                if (lastMove != null && lastMove.getFrom() == forwardRight) {
                    moves.add(new KillMove(turn, startSquare, forwardRight, right.getPiece()));
                }
            }
        }

        return moves;
    }
}
