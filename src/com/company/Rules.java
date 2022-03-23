package com.company;

public interface Rules {
    public String howToMove(String color); //how to play (dice or Square selection etc...) - Press Enter to throw the dice / choose source square and destination square / choose square to put piece

    public boolean rules(String input,Board state,String color,Move move); // set in move vals
}
