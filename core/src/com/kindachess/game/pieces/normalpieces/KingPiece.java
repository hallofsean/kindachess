package com.kindachess.game.pieces.normalpieces;

import com.kindachess.game.moves.normalmoves.SingleMoveScanner;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.Team;

public class KingPiece extends AbstractPiece {
    public KingPiece(AbstractSquare square, Team team) {
        super(square, team, (team == Team.WHITE) ? "WK" : "BK");
        addMoveType(new SingleMoveScanner());
    }
}
