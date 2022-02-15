package com.company;

public class Rook extends Piece{

    public boolean isLegalMove(Locations loc, Board state){
        Location src = loc.getSrc();
        Location dst = loc.getDst();
        int i = src.getX();
        int j = src.getY();
        int x = src.getX() - dst.getX();
        int y = src.getY() - dst.getY();
        // check if legal move
        if (!(x == 0 || y == 0)) { // vertical or horizontal (x == 0 || y == 0 )
            return false;
        }

        // check if rook did not "jump" over any piece on the board
        int iter = Math.max(Math.abs(x),Math.abs(y)) - 1; // last square can be with piece (-1)
        if (x != 0) {x /= Math.abs(x);} // 0, 1 or -1
        if (y != 0) {y /= Math.abs(y);} // 0, 1 or -1
        for (int t = 0; t < iter - 1 ; t++)
        {
            i += x;
            j += y;
            if(state[i][j] != null){return false;}
        }
        //todo:(after rules in player or isGameOver) check if after moving the rook it is not checkmate
        return true;
    }
}