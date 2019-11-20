package com.kindachess.game.util;

import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractSquare;

public class KillMove extends Move {
    private AbstractPiece target;

    public KillMove(int turn, AbstractSquare from, AbstractSquare to, AbstractPiece target) {
        super(turn, from, to);
        this.target = target;
    }

    public AbstractPiece getTarget() {
        return target;
    }
}
