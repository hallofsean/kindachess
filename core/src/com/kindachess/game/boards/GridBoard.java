package com.kindachess.game.boards;

import com.kindachess.game.squares.AbstractGridSquare;

public interface GridBoard {
    public AbstractGridSquare getUp(AbstractGridSquare square);

    public AbstractGridSquare getDown(AbstractGridSquare square);

    public AbstractGridSquare getLeft(AbstractGridSquare square);

    public AbstractGridSquare getRight(AbstractGridSquare square);

    public AbstractGridSquare getSquare(int x, int y);
}
