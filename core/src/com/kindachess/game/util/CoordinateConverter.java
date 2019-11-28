package com.kindachess.game.util;

import com.kindachess.game.boards.AbstractGridBoard;

/**
 * CoordinateConverter
 */
public class CoordinateConverter {
    public static int[] screenToBoardCoordinates(AbstractGridBoard board, int screenX, int screenY) {
        int x = screenX / board.getSquareSize();
        int y = board.getHeight() - 1 - (screenY / board.getSquareSize());
        return new int[]{x, y};
    }
}