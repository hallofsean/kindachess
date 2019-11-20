package com.kindachess.game.squares;

import com.kindachess.game.boards.AbstractBoard;
import com.kindachess.game.exceptions.IncorrectSquareTypeException;

public class NormalSquare extends AbstractGridSquare {
    public NormalSquare(AbstractBoard board, int x, int y) throws IncorrectSquareTypeException {
        super(board, x, y);
    }
}
