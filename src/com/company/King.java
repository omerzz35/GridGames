package com.company;

public class King extends Piece{

    public King(String color) {
        this.color = color;
        this.name = "King";
    }

    public boolean isLegalMove(Locations loc, Board state, boolean gameOver){
        Location src = loc.getSrc();
        Location dst = loc.getDst();
        int j = src.getX();
        int i = src.getY();
        if (!(Math.abs(src.getX() - dst.getX()) <= 1 && Math.abs(src.getY() - dst.getY()) <= 1) || (Math.abs(src.getX() - dst.getX()) == 0  && Math.abs(src.getY() - dst.getY()) == 0))
        {
            return false;
        }
        return this.color.equals(state.getState()[i][j].getColor());
    }
}
