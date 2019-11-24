package com.kindachess.game.pieces.normalpieces;

import com.kindachess.game.moves.normalmoves.*;
import com.kindachess.game.squares.AbstractSquare;
import com.kindachess.game.util.Team;

/**
 * Builder design pattern for StandardPiece
 */
public class StandardPieceBuilder {
    public static StandardPiece create(StandardPieceType type, AbstractSquare square, Team team) {
        StandardPiece piece = new StandardPiece(square, team);

        switch (type) {
            case QUEEN:
                createQueen(piece);
                break;
            case BISHOP:
                createBishop(piece);
                break;
            case KNIGHT:
                createKnight(piece);
                break;
            case ROOK:
                createRook(piece);
                break;
            case PAWN:
                createPawn(piece);
                break;
        }

        return piece;
    }

    private static void createQueen(StandardPiece piece) {
        piece.addMoveType(new DiagonalMoveScanner());
        piece.addMoveType(new StraightMoveScanner());
    }

    private static void createBishop(StandardPiece piece) {
        piece.addMoveType(new DiagonalMoveScanner());
    }

    private static void createKnight(StandardPiece piece) {
        piece.addMoveType(new KnightMoveScanner());
    }

    private static void createRook(StandardPiece piece) {
        piece.addMoveType(new StraightMoveScanner());
    }

    private static void createPawn(StandardPiece piece) {
        piece.addMoveType(new SingleForwardMoveScanner());
        piece.addMoveType(new PawnAttackMoveScanner());
    }
}
