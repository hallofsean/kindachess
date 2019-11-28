package com.kindachess.game.moves.normalmoves;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import com.kindachess.exceptions.InvalidBoardTypeException;
import com.kindachess.game.boards.AbstractBoard;
import com.kindachess.game.boards.AbstractGridBoard;
import com.kindachess.game.games.AbstractGameType;
import com.kindachess.game.pieces.AbstractPiece;
import com.kindachess.game.squares.AbstractGridSquare;
import com.kindachess.game.util.KillMove;
import com.kindachess.game.util.Move;
import com.kindachess.game.util.Team;

public class StraightMoveScannerTest {
    private AbstractBoard board;
    private AbstractGridSquare start;
    private StraightMoveScanner scanner;
    private AbstractPiece piece;
    private AbstractPiece target;

    public AbstractGridSquare newEmptySquare() {
        AbstractGridSquare square = mock(AbstractGridSquare.class);
        when(square.getBoard()).thenReturn(board);
        return square;
    }

    public List<Move> getMoves() {
        try {
            return scanner.getMoves(piece);
        } catch (InvalidBoardTypeException e) {
            fail(e.getMessage());
        }
        return null;
    }

    @Before
    public void setup() {
        board = mock(AbstractGridBoard.class);
        start = newEmptySquare();
        piece = mock(AbstractPiece.class);
        target = mock(AbstractPiece.class);
        AbstractGameType gameType = mock(AbstractGameType.class);
        when(piece.getSquare()).thenReturn(start);
        when(start.getPiece()).thenReturn(piece);
        when(piece.getTeam()).thenReturn(Team.BLACK);
        when(target.getTeam()).thenReturn(Team.WHITE);
        when(start.getBoard()).thenReturn(board);
        when(start.getBoard().getGameType()).thenReturn(gameType);
        when(start.getBoard().getGameType().getTurnCount()).thenReturn(1);

        scanner = new StraightMoveScanner();
    }

    @Test
    public void noStart() {
        List<Move> moves = getMoves();

        assertTrue("List of moves contains starting square", moves.isEmpty());
    }

    @Test
    public void upEmpty() {
        AbstractGridSquare s1 = newEmptySquare();
        AbstractGridSquare s2 = newEmptySquare();
        AbstractGridSquare s3 = newEmptySquare();
        AbstractGridSquare s4 = newEmptySquare();

        when(start.getUp()).thenReturn(s1);
        when(s1.getUp()).thenReturn(s2);
        when(s2.getUp()).thenReturn(s3);
        when(s3.getUp()).thenReturn(s4);
        
        List<Move> moves = getMoves();
        Move m1 = new Move(1, start, s1);
        Move m2 = new Move(1, start, s2);
        Move m3 = new Move(1, start, s3);
        Move m4 = new Move(1, start, s4);

        assertEquals("More moves returned than expected", 4, moves.size());
        assertTrue("No move to square 1", moves.contains(m1));
        assertTrue("No move to square 2", moves.contains(m2));
        assertTrue("No move to square 3", moves.contains(m3));
        assertTrue("No move to square 4", moves.contains(m4));
    }

    @Test
    public void upObstructed() {
        AbstractGridSquare s1 = newEmptySquare();
        AbstractGridSquare s2 = newEmptySquare();
        AbstractGridSquare s3 = newEmptySquare();
        AbstractGridSquare s4 = newEmptySquare();

        when(start.getUp()).thenReturn(s1);
        when(s1.getUp()).thenReturn(s2);
        when(s2.getUp()).thenReturn(s3);
        when(s3.getUp()).thenReturn(s4);
        when(s3.isObstructed()).thenReturn(true);
        
        List<Move> moves = getMoves();
        Move m1 = new Move(1, start, s1);
        Move m2 = new Move(1, start, s2);

        assertEquals("More moves returned than expected", 2, moves.size());
        assertTrue("No move to square 1", moves.contains(m1));
        assertTrue("No move to square 2", moves.contains(m2));
    }

    @Test
    public void upKill() {
        AbstractGridSquare s1 = newEmptySquare();
        AbstractGridSquare s2 = newEmptySquare();
        AbstractGridSquare s3 = newEmptySquare();
        AbstractGridSquare s4 = newEmptySquare();

        when(start.getUp()).thenReturn(s1);
        when(s1.getUp()).thenReturn(s2);
        when(s2.getUp()).thenReturn(s3);
        when(s3.getUp()).thenReturn(s4);
        when(s3.isObstructed()).thenReturn(true);
        when(s3.getPiece()).thenReturn(target);
        
        
        List<Move> moves = getMoves();
        Move m1 = new Move(1, start, s1);
        Move m2 = new Move(1, start, s2);
        Move m3 = new KillMove(1, start, s3, target);

        assertEquals("More moves returned than expected", 3, moves.size());
        assertTrue("No move to square 1", moves.contains(m1));
        assertTrue("No move to square 2", moves.contains(m2));
        assertTrue("No kill move to square 3", moves.contains(m3));
    }

    @Test
    public void downEmpty() {
        AbstractGridSquare s1 = newEmptySquare();
        AbstractGridSquare s2 = newEmptySquare();
        AbstractGridSquare s3 = newEmptySquare();
        AbstractGridSquare s4 = newEmptySquare();

        when(start.getDown()).thenReturn(s1);
        when(s1.getDown()).thenReturn(s2);
        when(s2.getDown()).thenReturn(s3);
        when(s3.getDown()).thenReturn(s4);
        
        List<Move> moves = getMoves();
        Move m1 = new Move(1, start, s1);
        Move m2 = new Move(1, start, s2);
        Move m3 = new Move(1, start, s3);
        Move m4 = new Move(1, start, s4);

        assertEquals("More moves returned than expected", 4, moves.size());
        assertTrue("No move to square 1", moves.contains(m1));
        assertTrue("No move to square 2", moves.contains(m2));
        assertTrue("No move to square 3", moves.contains(m3));
        assertTrue("No move to square 4", moves.contains(m4));
    }

    @Test
    public void downObstructed() {
        AbstractGridSquare s1 = newEmptySquare();
        AbstractGridSquare s2 = newEmptySquare();
        AbstractGridSquare s3 = newEmptySquare();
        AbstractGridSquare s4 = newEmptySquare();

        when(start.getDown()).thenReturn(s1);
        when(s1.getDown()).thenReturn(s2);
        when(s2.getDown()).thenReturn(s3);
        when(s3.getDown()).thenReturn(s4);
        when(s3.isObstructed()).thenReturn(true);
        
        List<Move> moves = getMoves();
        Move m1 = new Move(1, start, s1);
        Move m2 = new Move(1, start, s2);

        assertEquals("More moves returned than expected", 2, moves.size());
        assertTrue("No move to square 1", moves.contains(m1));
        assertTrue("No move to square 2", moves.contains(m2));
    }

    @Test
    public void downKill() {
        AbstractGridSquare s1 = newEmptySquare();
        AbstractGridSquare s2 = newEmptySquare();
        AbstractGridSquare s3 = newEmptySquare();
        AbstractGridSquare s4 = newEmptySquare();

        when(start.getDown()).thenReturn(s1);
        when(s1.getDown()).thenReturn(s2);
        when(s2.getDown()).thenReturn(s3);
        when(s3.getDown()).thenReturn(s4);
        when(s3.isObstructed()).thenReturn(true);
        when(s3.getPiece()).thenReturn(target);
        
        
        List<Move> moves = getMoves();
        Move m1 = new Move(1, start, s1);
        Move m2 = new Move(1, start, s2);
        Move m3 = new KillMove(1, start, s3, target);

        assertEquals("More moves returned than expected", 3, moves.size());
        assertTrue("No move to square 1", moves.contains(m1));
        assertTrue("No move to square 2", moves.contains(m2));
        assertTrue("No kill move to square 3", moves.contains(m3));
    }

    @Test
    public void leftEmpty() {
        AbstractGridSquare s1 = newEmptySquare();
        AbstractGridSquare s2 = newEmptySquare();
        AbstractGridSquare s3 = newEmptySquare();
        AbstractGridSquare s4 = newEmptySquare();

        when(start.getLeft()).thenReturn(s1);
        when(s1.getLeft()).thenReturn(s2);
        when(s2.getLeft()).thenReturn(s3);
        when(s3.getLeft()).thenReturn(s4);
        
        List<Move> moves = getMoves();
        Move m1 = new Move(1, start, s1);
        Move m2 = new Move(1, start, s2);
        Move m3 = new Move(1, start, s3);
        Move m4 = new Move(1, start, s4);

        assertEquals("More moves returned than expected", 4, moves.size());
        assertTrue("No move to square 1", moves.contains(m1));
        assertTrue("No move to square 2", moves.contains(m2));
        assertTrue("No move to square 3", moves.contains(m3));
        assertTrue("No move to square 4", moves.contains(m4));
    }

    @Test
    public void leftObstructed() {
        AbstractGridSquare s1 = newEmptySquare();
        AbstractGridSquare s2 = newEmptySquare();
        AbstractGridSquare s3 = newEmptySquare();
        AbstractGridSquare s4 = newEmptySquare();

        when(start.getLeft()).thenReturn(s1);
        when(s1.getLeft()).thenReturn(s2);
        when(s2.getLeft()).thenReturn(s3);
        when(s3.getLeft()).thenReturn(s4);
        when(s3.isObstructed()).thenReturn(true);
        
        List<Move> moves = getMoves();
        Move m1 = new Move(1, start, s1);
        Move m2 = new Move(1, start, s2);

        assertEquals("More moves returned than expected", 2, moves.size());
        assertTrue("No move to square 1", moves.contains(m1));
        assertTrue("No move to square 2", moves.contains(m2));
    }

    @Test
    public void leftKill() {
        AbstractGridSquare s1 = newEmptySquare();
        AbstractGridSquare s2 = newEmptySquare();
        AbstractGridSquare s3 = newEmptySquare();
        AbstractGridSquare s4 = newEmptySquare();

        when(start.getLeft()).thenReturn(s1);
        when(s1.getLeft()).thenReturn(s2);
        when(s2.getLeft()).thenReturn(s3);
        when(s3.getLeft()).thenReturn(s4);
        when(s3.isObstructed()).thenReturn(true);
        when(s3.getPiece()).thenReturn(target);
        
        
        List<Move> moves = getMoves();
        Move m1 = new Move(1, start, s1);
        Move m2 = new Move(1, start, s2);
        Move m3 = new KillMove(1, start, s3, target);

        assertEquals("More moves returned than expected", 3, moves.size());
        assertTrue("No move to square 1", moves.contains(m1));
        assertTrue("No move to square 2", moves.contains(m2));
        assertTrue("No kill move to square 3", moves.contains(m3));
    }

    @Test
    public void rightEmpty() {
        AbstractGridSquare s1 = newEmptySquare();
        AbstractGridSquare s2 = newEmptySquare();
        AbstractGridSquare s3 = newEmptySquare();
        AbstractGridSquare s4 = newEmptySquare();

        when(start.getRight()).thenReturn(s1);
        when(s1.getRight()).thenReturn(s2);
        when(s2.getRight()).thenReturn(s3);
        when(s3.getRight()).thenReturn(s4);
        
        List<Move> moves = getMoves();
        Move m1 = new Move(1, start, s1);
        Move m2 = new Move(1, start, s2);
        Move m3 = new Move(1, start, s3);
        Move m4 = new Move(1, start, s4);

        assertEquals("More moves returned than expected", 4, moves.size());
        assertTrue("No move to square 1", moves.contains(m1));
        assertTrue("No move to square 2", moves.contains(m2));
        assertTrue("No move to square 3", moves.contains(m3));
        assertTrue("No move to square 4", moves.contains(m4));
    }

    @Test
    public void rightObstructed() {
        AbstractGridSquare s1 = newEmptySquare();
        AbstractGridSquare s2 = newEmptySquare();
        AbstractGridSquare s3 = newEmptySquare();
        AbstractGridSquare s4 = newEmptySquare();

        when(start.getRight()).thenReturn(s1);
        when(s1.getRight()).thenReturn(s2);
        when(s2.getRight()).thenReturn(s3);
        when(s3.getRight()).thenReturn(s4);
        when(s3.isObstructed()).thenReturn(true);
        
        List<Move> moves = getMoves();
        Move m1 = new Move(1, start, s1);
        Move m2 = new Move(1, start, s2);

        assertEquals("More moves returned than expected", 2, moves.size());
        assertTrue("No move to square 1", moves.contains(m1));
        assertTrue("No move to square 2", moves.contains(m2));
    }

    @Test
    public void rightKill() {
        AbstractGridSquare s1 = newEmptySquare();
        AbstractGridSquare s2 = newEmptySquare();
        AbstractGridSquare s3 = newEmptySquare();
        AbstractGridSquare s4 = newEmptySquare();

        when(start.getRight()).thenReturn(s1);
        when(s1.getRight()).thenReturn(s2);
        when(s2.getRight()).thenReturn(s3);
        when(s3.getRight()).thenReturn(s4);
        when(s3.isObstructed()).thenReturn(true);
        when(s3.getPiece()).thenReturn(target);
        
        
        List<Move> moves = getMoves();
        Move m1 = new Move(1, start, s1);
        Move m2 = new Move(1, start, s2);
        Move m3 = new KillMove(1, start, s3, target);

        assertEquals("More moves returned than expected", 3, moves.size());
        assertTrue("No move to square 1", moves.contains(m1));
        assertTrue("No move to square 2", moves.contains(m2));
        assertTrue("No kill move to square 3", moves.contains(m3));
    }
}