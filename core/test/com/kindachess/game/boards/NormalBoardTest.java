package com.kindachess.game.boards;

import com.kindachess.game.exceptions.KindaChessException;
import com.kindachess.game.exceptions.SquareNotOnBoardException;
import com.kindachess.game.games.AbstractGameType;
import com.kindachess.game.games.NormalGameType;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.pieces.normalpieces.StandardPieceBuilder;
import com.kindachess.game.pieces.normalpieces.StandardPieceType;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.Team;
import com.kindachess.game.TextureRegistry;
import com.kindachess.game.boards.NormalBoard;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;

public class NormalBoardTest {
    private NormalBoard board;

    @Before
    public void setup() throws KindaChessException {
        TextureRegistry.setInstance(mock(TextureRegistry.class));

        AbstractGameType gameType = new NormalGameType();
        board = new NormalBoard(gameType);
    }

    @Test
    public void addPiece() throws SquareNotOnBoardException {
        AbstractSquare square = board.getSquares().get(0);
        Team team = Team.BLACK;
        AbstractPiece piece = StandardPieceBuilder.create(StandardPieceType.ROOK, square, team);
        board.addPiece(piece);
        assertEquals(piece, board.getPieces().get(0));
    }

    @Test
    public void getPieces() throws SquareNotOnBoardException {
        AbstractSquare square1 = board.getSquares().get(0);
        AbstractSquare square2 = board.getSquares().get(1);
        AbstractSquare square3 = board.getSquares().get(2);

        AbstractPiece piece1 = StandardPieceBuilder.create(StandardPieceType.ROOK, square1, Team.WHITE);
        AbstractPiece piece2 = StandardPieceBuilder.create(StandardPieceType.ROOK, square2, Team.WHITE);
        AbstractPiece piece3 = StandardPieceBuilder.create(StandardPieceType.ROOK, square3, Team.WHITE);

        board.addPiece(piece1);
        board.addPiece(piece2);
        board.addPiece(piece3);

        assertTrue("Piece 1 not on board", board.getPieces().contains(piece1));
        assertTrue("Piece 2 not on board", board.getPieces().contains(piece2));
        assertTrue("Piece 3 not on board", board.getPieces().contains(piece3));
        assertEquals("Additional pieces on board", 3, board.getPieces().size());
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
