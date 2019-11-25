package com.kindachess.game.games;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kindachess.game.TextureRegistry;
import com.kindachess.game.boards.NormalBoard;
import com.kindachess.game.exceptions.IncorrectSquareTypeException;
import com.kindachess.game.exceptions.SquareNotOnBoardException;
import com.kindachess.game.pieces.normalpieces.StandardPiece;
import com.kindachess.game.pieces.normalpieces.StandardPieceBuilder;
import com.kindachess.game.pieces.normalpieces.StandardPieceType;
import com.kindachess.game.util.Team;
import com.kindachess.game.pieces.normalpieces.KingPiece;
import com.kindachess.game.pieces.normalpieces.PawnPiece;

public class NormalGameType extends AbstractGameType {
    private NormalBoard board;

    public NormalGameType() throws IncorrectSquareTypeException, SquareNotOnBoardException {
        board = new NormalBoard(this);

        // pieces
        //// Black Pieces
        KingPiece blackKing = new KingPiece(board.getSquare(4, 7), Team.BLACK);
        StandardPiece blackQueen = StandardPieceBuilder.create(StandardPieceType.QUEEN, board.getSquare(3, 7),
                Team.BLACK);
        StandardPiece blackKnight1 = StandardPieceBuilder.create(StandardPieceType.KNIGHT, board.getSquare(1, 7),
                Team.BLACK);
        StandardPiece blackKnight2 = StandardPieceBuilder.create(StandardPieceType.KNIGHT, board.getSquare(6, 7),
                Team.BLACK);
        StandardPiece blackBishop1 = StandardPieceBuilder.create(StandardPieceType.BISHOP, board.getSquare(2, 7),
                Team.BLACK);
        StandardPiece blackBishop2 = StandardPieceBuilder.create(StandardPieceType.BISHOP, board.getSquare(5, 7),
                Team.BLACK);
        StandardPiece blackRook1 = StandardPieceBuilder.create(StandardPieceType.ROOK, board.getSquare(0, 7),
                Team.BLACK);
        StandardPiece blackRook2 = StandardPieceBuilder.create(StandardPieceType.ROOK, board.getSquare(7, 7),
                Team.BLACK);
        board.addPiece(blackKing);
        board.addPiece(blackQueen);
        board.addPiece(blackKnight1);
        board.addPiece(blackKnight2);
        board.addPiece(blackBishop1);
        board.addPiece(blackBishop2);
        board.addPiece(blackRook1);
        board.addPiece(blackRook2);

        for (int i = 0; i < 8; i++) {
            board.addPiece(new PawnPiece(board.getSquare(i, 6), Team.BLACK));
        }

        //// White Pieces
        KingPiece whiteKing = new KingPiece(board.getSquare(4, 0), Team.WHITE);
        StandardPiece whiteQueen = StandardPieceBuilder.create(StandardPieceType.QUEEN, board.getSquare(3, 0),
                Team.WHITE);
        StandardPiece whiteKnight1 = StandardPieceBuilder.create(StandardPieceType.KNIGHT, board.getSquare(1, 0),
                Team.WHITE);
        StandardPiece whiteKnight2 = StandardPieceBuilder.create(StandardPieceType.KNIGHT, board.getSquare(6, 0),
                Team.WHITE);
        StandardPiece whiteBishop1 = StandardPieceBuilder.create(StandardPieceType.BISHOP, board.getSquare(2, 0),
                Team.WHITE);
        StandardPiece whiteBishop2 = StandardPieceBuilder.create(StandardPieceType.BISHOP, board.getSquare(5, 0),
                Team.WHITE);
        StandardPiece whiteRook1 = StandardPieceBuilder.create(StandardPieceType.ROOK, board.getSquare(0, 0),
                Team.WHITE);
        StandardPiece whiteRook2 = StandardPieceBuilder.create(StandardPieceType.ROOK, board.getSquare(7, 0),
                Team.WHITE);
        board.addPiece(whiteKing);
        board.addPiece(whiteQueen);
        board.addPiece(whiteKnight1);
        board.addPiece(whiteKnight2);
        board.addPiece(whiteBishop1);
        board.addPiece(whiteBishop2);
        board.addPiece(whiteRook1);
        board.addPiece(whiteRook2);

        for (int i = 0; i < 8; i++) {
            board.addPiece(new PawnPiece(board.getSquare(i, 1), Team.WHITE));
        }

    }

    @Override
    public void render(SpriteBatch batch) {
        board.render(batch);
    }

    @Override
    public void dispose() {
        TextureRegistry.getInstance().dispose();
    }
}
