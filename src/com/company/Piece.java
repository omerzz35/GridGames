package com.company;

public abstract class Piece {
    protected String name;
    protected String color;

    public String getColor(){return color;}
    public String getName(){return name;}
    public abstract boolean isLegalMove(Locations loc, Board state, boolean gameOver);
}
