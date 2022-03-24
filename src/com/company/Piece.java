package com.company;

public abstract class Piece {
    protected String name;
    protected String color;

    /**
     * @return the color
     */
    public String getColor(){return color;}

    /**
     * @return the name
     */
    public String getName(){return name;}

    /**
     * @param loc - Locations (src and dst)
     * @param state - the state of the board
     * @param gameOver - is the games started
     * @return is legal move
     */
    public abstract boolean isLegalMove(Locations loc, Board state, boolean gameOver);
}
