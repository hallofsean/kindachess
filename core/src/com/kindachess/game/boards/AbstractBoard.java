package com.kindachess.game.boards;

import com.kindachess.game.exceptions.IncorrectSquareTypeException;
import com.kindachess.game.exceptions.SquareNotOnBoardException;
import com.kindachess.game.games.AbstractGameType;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractSquare;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public abstract class AbstractBoard {
    private Map<AbstractSquare, AbstractPiece> pieces = new ConcurrentHashMap<>();
    private AbstractGameType game;

    public AbstractBoard(AbstractGameType gameType) {
        game = gameType;
    }

    public abstract List<AbstractSquare> getNeighbours(AbstractSquare square) throws IncorrectSquareTypeException;

    public abstract List<AbstractSquare> getSquares();

    public void addPiece(AbstractSquare square, AbstractPiece piece) throws SquareNotOnBoardException {
        if (!getSquares().contains(square)) {
            throw new SquareNotOnBoardException();
        }
        pieces.put(square, piece);
    }

    public List<AbstractPiece> getPieces() {
        return new ArrayList<>(pieces.values());
    }

    public boolean isObstructed(AbstractSquare square) {
        for (AbstractPiece piece : getPieces()) {
            if (piece.getSquare() == square) {
                return true;
            }
        }

        return false;
    }

    public AbstractPiece getPieceOnSquare(AbstractSquare square) {
        return pieces.get(square);
    }

    public AbstractGameType getGame() {
        return game;
    }
}
