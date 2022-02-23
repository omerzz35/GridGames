package com.company;

public class Knight extends Piece {

    public Knight(String color) {
        this.color = color;
        this.name = "Knight";
    }

    public boolean isLegalMove(Locations loc, Board state) {
        Location src = loc.getSrc();
        Location dst = loc.getDst();

        int i = src.getX();
        int j = src.getY();
        int x = src.getX() - dst.getX();
        int y = src.getY() - dst.getY();

        if (Math.abs(x) == 1 && Math.abs(y) == 2) {
            return true;
        }
        if (Math.abs(x) == 2 && Math.abs(y) == 1) {
            return true;
        }
        return false;
    }
}
