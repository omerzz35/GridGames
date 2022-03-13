package com.company;

public class Bishop extends Piece{

    public Bishop(String color) {
        this.color = color;
        this.name = "Bishop";
    }

    public boolean isLegalMove(Locations loc, Board state, boolean gameOver){
        Location src = loc.getSrc();
        Location dst = loc.getDst();
        int j = src.getX();
        int i = src.getY();
        int x = dst.getX() - src.getX();
        int y = dst.getY() - src.getY();
        // check if legal move
        if (!(Math.abs(x) == Math.abs(y))) { //diagonal (x == y)
            return false;
        }

        // check if bishop did not "jump" over any piece on the board
        int iter = Math.max(Math.abs(x),Math.abs(y)) - 1; // last square can be with piece (-1)
        if (x != 0) {x /= Math.abs(x);} // 0, 1 or -1
        if (y != 0) {y /= Math.abs(y);} // 0, 1 or -1
        for (int t = 0; t < iter ; t++)
        {
            i += y;
            j += x;
            if(state.getState()[i][j] != null){return false;}
        }
        //todo:(after rules in player or isGameOver) check if after moving the bishop it is not checkmate
        return true;
    }
}
