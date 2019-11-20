package com.kindachess.game.boards;

import com.kindachess.game.exceptions.IncorrectSquareTypeException;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.pieces.normalpieces.KingPiece;
import com.kindachess.game.pieces.normalpieces.StandardPiece;
import com.kindachess.game.pieces.normalpieces.StandardPieceBuilder;
import com.kindachess.game.pieces.normalpieces.StandardPieceType;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.squares.NormalSquare;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NormalBoardTest {
    private NormalBoard board;

    @Before
    public void setup() throws IncorrectSquareTypeException {
        board = new NormalBoard();
    }

    @Test
    public void addPiece() {
        AbstractSquare square = board.getSquares().get(0);
        AbstractPiece piece = StandardPieceBuilder.create(StandardPieceType.ROOK, square);
        board.addPiece(piece);
        assertEquals(piece, board.getPieces().get(0));
    }

    @Test
    public void getPieces() {
        AbstractSquare square = board.getSquares().get(0);
        AbstractPiece piece1 = StandardPieceBuilder.create(StandardPieceType.ROOK, square);
        AbstractPiece piece2 = StandardPieceBuilder.create(StandardPieceType.ROOK, square);
        AbstractPiece piece3 = StandardPieceBuilder.create(StandardPieceType.ROOK, square);
        board.addPiece(piece1);
        board.addPiece(piece2);
        board.addPiece(piece3);

        assertEquals(piece1, board.getPieces().get(0));
        assertEquals(piece2, board.getPieces().get(1));
        assertEquals(piece3, board.getPieces().get(2));
    }

    @Test
    public void isObstructed() {
    }

    @Test
    public void getSquares() {

    }

    @Test
    public void getNeighbours() {
    }

    @Test
    public void getUp() {
    }

    @Test
    public void getDown() {
    }

    @Test
    public void getLeft() {
    }

    @Test
    public void getRight() {
    }
}
