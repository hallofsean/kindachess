package com.kindachess.game.moves;

import com.kindachess.game.exceptions.InvalidBoardTypeException;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.util.Move;

import java.util.List;

public abstract class AbstractMoveScanner {
    public abstract List<Move> getMoves(AbstractPiece piece)
            throws InvalidBoardTypeException;
}
