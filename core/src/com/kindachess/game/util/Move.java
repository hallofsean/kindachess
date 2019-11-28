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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Move)) {
            return false;
        }

        boolean sameTurn = turn == ((Move) obj).getTurn();
        boolean sameFrom = from == ((Move) obj).getFrom();
        boolean sameTo = to == ((Move) obj).getTo();

        return sameTurn && sameFrom && sameTo;
    }
}
