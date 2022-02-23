package com.company;

public class King extends Piece{
    private boolean isMoved = false; //htzraha

    public King(String color) {
        this.color = color;
        this.name = "King";
    }

    public boolean isLegalMove(Locations loc, Board state){
        Location src = loc.getSrc();
        Location dst = loc.getDst();
        if (!(Math.abs(src.getX() - dst.getX()) <=1 && Math.abs(src.getY() - dst.getY()) <=1)){return false;}
        //todo:(after rules in player or isGameOver) check if after moving the king it is not checkmate
        return true;
    }
}
