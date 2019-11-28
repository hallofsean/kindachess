package com.kindachess.game.boards;

import com.kindachess.game.games.AbstractGameType;
import com.kindachess.game.squares.AbstractGridSquare;

public abstract class AbstractGridBoard extends AbstractBoard {
    public AbstractGridBoard(AbstractGameType gameType) {
        super(gameType);
    }

    public abstract AbstractGridSquare getUp(AbstractGridSquare square);

    public abstract AbstractGridSquare getDown(AbstractGridSquare square);

    public abstract AbstractGridSquare getLeft(AbstractGridSquare square);

    public abstract AbstractGridSquare getRight(AbstractGridSquare square);

    public abstract AbstractGridSquare getSquare(int x, int y);

    public abstract int getSquareSize();

    public abstract int getHeight();

    public abstract int getWidth();
}
