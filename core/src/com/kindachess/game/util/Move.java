package com.kindachess.game.util;

import com.kindachess.game.squares.AbstractSquare;

public class Move {
    private int turn;
    private AbstractSquare from;
    private AbstractSquare to;

    public Move(int turn, AbstractSquare from, AbstractSquare to) {
        this.turn = turn;
        this.from = from;
        this.to = to;
    }

    public int getTurn() {
        return turn;
    }

    public AbstractSquare getFrom() {
        return from;
    }

    public AbstractSquare getTo() {
        return to;
    }
}
