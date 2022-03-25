package com.company;

public class Knight extends Piece {

    /**
     * Constructor
     * @param color color of the piece
     */
    public Knight(String color) {
        this.color = color;
        this.name = "Knight";
    }

    /**
     * @param loc      - Locations (src and dst)
     * @param state    - the state of the board
     * @param gameOver - is the games started
     * @return boolean if move is legal to make for current piece
     */
    public boolean isLegalMove(Locations loc, Board state, boolean gameOver) {
        Location src = loc.getSrc();
        Location dst = loc.getDst();

        int j = src.getX();
        int i = src.getY();
        int x = dst.getX() - src.getX();
        int y = dst.getY() - src.getY();

        if ((Math.abs(x) == 1 && Math.abs(y) == 2) || (Math.abs(x) == 2 && Math.abs(y) == 1)) {
            return true;
            //return this.color.equals(state.getState()[j][i].getColor());
        }
        return false;
    }
}
