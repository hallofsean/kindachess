package com.kindachess.game.pieces;

import com.kindachess.game.exceptions.InvalidBoardTypeException;
import com.kindachess.game.moves.AbstractMoveScanner;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.Move;
import com.kindachess.game.util.Team;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractPiece {
    private List<AbstractMoveScanner> moveTypes = new CopyOnWriteArrayList<>();
    private AbstractSquare square;
    private Team team;
    private CopyOnWriteArrayList<Move> moveHistory;

    public AbstractPiece(AbstractSquare startSquare, Team team) {
        square = startSquare;
        this.team = team;
    }

    public void addMoveType(AbstractMoveScanner moveType) {
        moveTypes.add(moveType);
    }

    protected List<AbstractMoveScanner> getMoveTypes() {
        return new ArrayList<>(moveTypes);
    }

    public List<Move> getMoves() throws InvalidBoardTypeException {
        Set<Move> moves = new HashSet<>();
        for (AbstractMoveScanner moveType : moveTypes) {
            moves.addAll(moveType.getMoves(this));
        }
        return new ArrayList<>(moves);
    }

    public boolean moveTo(AbstractSquare square) throws InvalidBoardTypeException {
        moveHistory.add(new Move(this.square.getBoard().getGame().getTurnCount(), this.square, square));
        this.square = square;
        return true;
    }

    public AbstractSquare getSquare() {
        return square;
    }

    public Team getTeam() {
        return team;
    }

    public int getMoveCount() {
        return moveHistory.size();
    }

    public Move getLastMove() {
        return moveHistory.get(moveHistory.size()-1);
    }
}
