package com.kindachess.game.moves.normalmoves;

import com.kindachess.game.exceptions.InvalidBoardTypeException;
import com.kindachess.game.moves.AbstractMoveScanner;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractGridSquare;
import com.kindachess.game.util.KillMove;
import com.kindachess.game.util.Move;

import java.util.LinkedList;
import java.util.List;

public class PawnAttackMoveScanner extends AbstractMoveScanner {
    @Override
    public List<Move> getMoves(AbstractPiece piece) throws InvalidBoardTypeException {
        List<Move> moves = new LinkedList<>();
        SingleForwardMoveScanner forwardMove = new SingleForwardMoveScanner();

        if (forwardMove.getMoves(piece).size() > 0) {
            Move forward = forwardMove.getMoves(piece).get(0);
            AbstractGridSquare forwardSquare = (AbstractGridSquare) forward.getTo();
            AbstractGridSquare forwardLeft = forwardSquare.getLeft();
            AbstractGridSquare forwardRight = forwardSquare.getRight();

            if (forwardLeft != null && forwardLeft.getPiece() != null
                    && forwardLeft.getPiece().getTeam() != piece.getTeam()) {
                moves.add(new KillMove(forward.getTurn(), forward.getFrom(), forwardLeft, forwardRight.getPiece()));
            }

            if (forwardRight != null && forwardRight.getPiece() != null
                    && forwardRight.getPiece().getTeam() != piece.getTeam()) {
                moves.add(new KillMove(forward.getTurn(), forward.getFrom(), forwardRight, forwardRight.getPiece()));
            }
        }

        return moves;
    }
}
