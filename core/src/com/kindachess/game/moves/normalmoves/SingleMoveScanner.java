package com.kindachess.game.moves.normalmoves;

import com.kindachess.game.exceptions.InvalidBoardTypeException;
import com.kindachess.game.moves.AbstractMoveScanner;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractSquare;

import java.util.List;

public class SingleMoveScanner extends AbstractMoveScanner {
    @Override
    public List<AbstractSquare> getMoves(AbstractPiece piece) throws InvalidBoardTypeException {
        AbstractSquare start = piece.getSquare();
        return start.getNeighbours();
    }
}
