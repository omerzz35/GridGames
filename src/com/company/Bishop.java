package com.company;

public class Bishop extends Piece{

    public Bishop(String color) {
        this.color = color;
        this.name = "Bishop";
    }


    /**
     * @param loc      - Locations (src and dst)
     * @param state    - the state of the board
     * @param gameOver - is the games started
     * @return
     */
    public boolean isLegalMove(Locations loc, Board state, boolean gameOver){
        Location src = loc.getSrc();
        Location dst = loc.getDst();
        int j = src.getX();
        int i = src.getY();
        int dx = dst.getX() - src.getX();
        int dy = dst.getY() - src.getY();

        // check if legal move
        if (!(Math.abs(dx) == Math.abs(dy))) { //diagonal (dx == dy)
            return false;
        }

        // check if bishop did not "jump" over any piece on the board
        int iter = Math.max(Math.abs(dx),Math.abs(dy)) - 1; // last square can be with piece (-1)
        if (dx != 0) {
            dx /= Math.abs(dx);} // 0, 1 or -1
        if (dy != 0) {
            dy /= Math.abs(dy);} // 0, 1 or -1
        for (int t = 0; t < iter ; t++)
        {
            i += dy;
            j += dx;
            if(state.getState()[i][j] != null){return false;}
        }
        return true;
    }
}
