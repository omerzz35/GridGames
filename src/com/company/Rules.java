package com.company;

public interface Rules {
    public String howToMove(); //how to play (dice or Square selection etc...) - Press Enter to throw the dice / choose source square and destination square / choose square to put piece
    // in how to move check simple things, like location in board (0 <=x,y< board.size)
    public boolean rules(String input,Board state,String color,Move move); // set in move vals
}
