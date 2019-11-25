package com.kindachess.game.moves.normalmoves;

import com.kindachess.game.exceptions.InvalidBoardTypeException;
import com.kindachess.game.moves.AbstractMoveScanner;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.Move;

import java.util.LinkedList;
import java.util.List;

public class SingleMoveScanner extends AbstractMoveScanner {
    @Override
    public List<Move> getMoves(AbstractPiece piece) throws InvalidBoardTypeException {
        AbstractSquare start = piece.getSquare();
        List<Move> moves = new LinkedList<>();
        for (AbstractSquare square : start.getNeighbours()) {
            moves.add(new Move(start.getBoard().getGame().getTurnCount(), start, square));
        }
        return moves;
    }
}
