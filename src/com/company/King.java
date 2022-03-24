package com.company;

public class King extends Piece{

    /**
     * @param color - the color of the King
     * constructor
     */
    public King(String color) {
        this.color = color;
        this.name = "King";
    }

    /**
     * @param loc - Locations (src and dst)
     * @param state - the state of the board
     * @param gameOver - is the games started
     * @return is legal move
     */
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
