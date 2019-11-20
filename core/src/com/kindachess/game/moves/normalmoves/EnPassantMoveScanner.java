package com.kindachess.game.moves.normalmoves;

import com.kindachess.game.exceptions.InvalidBoardTypeException;
import com.kindachess.game.moves.AbstractMoveScanner;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.pieces.normalpieces.PawnPiece;
import com.kindachess.game.squares.AbstractGridSquare;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.Move;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.abs;

public class EnPassantMoveScanner extends AbstractMoveScanner {
    @Override
    public List<AbstractSquare> getMoves(AbstractPiece piece) throws InvalidBoardTypeException {
        List<AbstractSquare> moves = new LinkedList<>();
        SingleForwardMoveScanner forwardMove = new SingleForwardMoveScanner();

        if (forwardMove.getMoves(piece).size() > 0) {
            AbstractGridSquare start = (AbstractGridSquare) piece.getSquare();
            AbstractGridSquare forward = (AbstractGridSquare) forwardMove.getMoves(piece).get(0);
            AbstractGridSquare forwardLeft = forward.getLeft();
            AbstractGridSquare forwardRight = forward.getRight();
            AbstractGridSquare left = start.getLeft();
            AbstractGridSquare right = start.getRight();

            if (left != null
                    && left.getPiece() != null
                    && left.getPiece() instanceof PawnPiece
            ) {
                Move lastMove = left.getPiece().getLastMove();
            }

            if (forwardRight != null
                    && forwardRight.getPiece() != null
                    && forwardRight.getPiece().getTeam() != piece.getTeam()) {
                moves.add(forwardRight);
            }
        }

        return moves;
    }
}
