package com.kindachess.game.pieces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.kindachess.game.exceptions.InvalidBoardTypeException;
import com.kindachess.game.moves.AbstractMoveScanner;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.Move;
import com.kindachess.game.util.Team;
import com.kindachess.game.TextureRegistry;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPiece {
    private List<AbstractMoveScanner> moveTypes = new CopyOnWriteArrayList<>();
    private AbstractSquare square;
    private Team team;
    private CopyOnWriteArrayList<Move> moveHistory;
    private Texture texture;

    private static Logger LOGGER = LoggerFactory.getLogger(AbstractPiece.class);

    public AbstractPiece(AbstractSquare startSquare, Team team, String textureName) {
        square = startSquare;
        this.team = team;
        texture = TextureRegistry.getInstance().getTexture(textureName);
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

    public void setTexture(String textureName) {
        texture = TextureRegistry.getInstance().getTexture(textureName);
    }

    public void render(SpriteBatch batch, int x, int y, int size) {
        LOGGER.trace("Rendering piece at ({}, {})", x*size, y*size);
        batch.draw(texture, x*size, y*size, size, size);
    }
}
