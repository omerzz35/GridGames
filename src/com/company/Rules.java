package com.company;

public interface Rules {

    /**
     * @param color the color of the player that needs to make the move
     * @return string that represents the move
     */
    public String howToMove(String color); //how to play (dice or Square selection etc...) - Press Enter to throw the dice / choose source square and destination square / choose square to put piece

    /**
     *
     * @param input - the string that represents the move
     * @param state - state of the board
     * @param color - the color of the player that needs to make the move
     * @param move - the object of move that contains information of what should change in the board
     * @return boolean - should make more move/s?
     */
    public boolean rules(String input,Board state,String color,Move move); // set in move vals
}
