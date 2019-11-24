package com.kindachess.game.pieces.normalpieces;

import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.Team;

/**
 * A regular piece with no special behaviour
 */
public class StandardPiece extends AbstractPiece {
    StandardPiece(AbstractSquare square, Team team, String textureName) {
        super(square, team, textureName);
    }
}
