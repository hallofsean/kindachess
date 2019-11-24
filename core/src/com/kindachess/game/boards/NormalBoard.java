package com.kindachess.game.boards;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kindachess.game.exceptions.IncorrectSquareTypeException;
import com.kindachess.game.games.AbstractGameType;
import com.kindachess.game.squares.AbstractGridSquare;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.squares.NormalSquare;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NormalBoard extends AbstractBoard implements GridBoard {
    private NormalSquare[][] grid = new NormalSquare[8][8]; // 0,0 is top-left

    public NormalBoard(AbstractGameType gameType) throws IncorrectSquareTypeException {
        super(gameType);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new NormalSquare(this, i, j);
            }
        }
    }

    @Override
    public List<AbstractSquare> getSquares() {
        List<AbstractSquare> squares = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            squares.addAll(Arrays.asList(grid[i]).subList(0, 8));
        }
        return squares;
    }

    @Override
    public List<AbstractSquare> getNeighbours(AbstractSquare square)
            throws IncorrectSquareTypeException {
        if (!(square instanceof NormalSquare)) {
            throw new IncorrectSquareTypeException();
        }

        List<AbstractSquare> neighbours = new LinkedList<>();

        if (getUp((NormalSquare) square) != null) {
            neighbours.add(getUp((NormalSquare) square));
        }

        if (getDown((NormalSquare) square) != null) {
            neighbours.add(getDown((NormalSquare) square));
        }

        if (getLeft((NormalSquare) square) != null) {
            neighbours.add(getLeft((NormalSquare) square));
        }

        if (getRight((NormalSquare) square) != null) {
            neighbours.add(getRight((NormalSquare) square));
        }

        return neighbours;
    }

    @Override
    public AbstractGridSquare getUp(AbstractGridSquare square) {
        if (square.getY() <= 0) {
            return null;
        }

        return grid[square.getX()][square.getY() - 1];
    }

    @Override
    public AbstractGridSquare getDown(AbstractGridSquare square) {
        if (square.getY() >= 7) {
            return null;
        }

        return grid[square.getX()][square.getY() + 1];
    }

    @Override
    public AbstractGridSquare getLeft(AbstractGridSquare square) {
        if (square.getX() <= 0) {
            return null;
        }

        return grid[square.getX() - 1][square.getY()];
    }

    @Override
    public AbstractGridSquare getRight(AbstractGridSquare square) {
        if (square.getX() >= 7) {
            return null;
        }

        return grid[square.getX() + 1][square.getY()];
    }

    @Override
    public void render(SpriteBatch batch) {
        int i = 0;
        int j = 0;
        for (NormalSquare[] row: grid) {
            j = 0;
            for (NormalSquare square: row) {
                square.render(batch, i, j++);
            }            
            i++;
        }
    }
}
