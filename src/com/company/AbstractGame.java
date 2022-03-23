package com.company;

public abstract class AbstractGame implements Rules{
    protected IO io;
    public AbstractGame(IO io) {
        this.io = io;
    }

    public abstract BoardAndColors initialize();

    public abstract boolean isGameOver(Board board);

    //how to play (dice or Square selection etc...) - Press Enter to throw the dice / choose source square and
    //destination square / choose square to put piece
    public abstract String howToMove(String color);

    public abstract boolean rules(String input, Board state, String color, Move move); // set values in move

    public abstract boolean shouldSDrawCoordination();

}

