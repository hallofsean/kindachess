package com.kindachess.game.pieces.normalpieces;

import com.kindachess.game.moves.normalmoves.EnPassantMoveScanner;
import com.kindachess.game.moves.normalmoves.PawnAttackMoveScanner;
import com.kindachess.game.moves.normalmoves.SingleForwardMoveScanner;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.Team;

public class PawnPiece extends AbstractPiece {
    PawnPiece(AbstractSquare square, Team team) {
        super(square, team);
        addMoveType(new SingleForwardMoveScanner());
        addMoveType(new PawnAttackMoveScanner());
        addMoveType(new EnPassantMoveScanner());
    }
}
