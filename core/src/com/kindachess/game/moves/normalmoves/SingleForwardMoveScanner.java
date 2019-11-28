package com.kindachess.game.moves.normalmoves;

import com.kindachess.game.boards.AbstractGridBoard;
import com.kindachess.exceptions.InvalidBoardTypeException;
import com.kindachess.game.moves.AbstractMoveScanner;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractGridSquare;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.Move;
import com.kindachess.game.util.Team;

import java.util.LinkedList;
import java.util.List;

public class SingleForwardMoveScanner extends AbstractMoveScanner {
    @Override
    public List<Move> getMoves(AbstractPiece piece) throws InvalidBoardTypeException {
        AbstractSquare start = piece.getSquare();
        if (!(start.getBoard() instanceof AbstractGridBoard)) {
            throw new InvalidBoardTypeException();
        }
        List<Move> moves = new LinkedList<>();

        AbstractSquare forward;
        if (piece.getTeam() == Team.WHITE) {
            forward = ((AbstractGridSquare) start).getUp();
        } else {
            forward = ((AbstractGridSquare) start).getDown();
        }
        if (forward != null) {
            moves.add(new Move(forward.getBoard().getGameType().getTurnCount(), start, forward));
        }

        return moves;
    }
}
