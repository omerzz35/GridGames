package com.company;

public class Rook extends Piece{

    /**
     * @param color - the color of the King
     * constructor
     */
    public Rook(String color) {
        this.color = color;
        this.name = "Rook";
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
        int x = dst.getX() - src.getX();
        int y = dst.getY() - src.getY();

        if (!(x == 0 || y == 0)) { // vertical or horizontal (x == 0 || y == 0 )
            return false;
        }

        // check if rook did not "jump" over any piece on the board
        int iter = Math.max(Math.abs(x),Math.abs(y)) - 1; // last square can be with piece (-1)
        if (x != 0) {x /= Math.abs(x);} // 0, 1 or -1
        if (y != 0) {y /= Math.abs(y);} // 0, 1 or -1
        for (int t = 0; t < iter ; t++)
        {
            i += y;
            j += x;
            if(state.getState()[i][j] != null){return false;}
        }

        return true;
    }
}
