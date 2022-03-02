package com.company;

public abstract class AbstractGame implements Rules{
    protected IO io;
    public AbstractGame(IO io) {
        this.io = io;
    }

    public abstract BoardAndColors initialize();
//    public Player getNextPlayer();
    public abstract boolean isGameOver();

    public abstract String howToMove(); //how to play (dice or Square selection etc...) - Press Enter to throw the dice / choose source square and destination square / choose square to put piece
    // todo: in how to move check simple things, like location in board (0 <=x,y< board.size)
    public abstract boolean rules(String input,Board state,String color,Move move); // set in move vals
}
