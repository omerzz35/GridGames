package com.company;

public class Pawn extends Piece{
    private boolean isFirstMove = true;

    public Pawn(String color){
        this.color = color;
        this.name = "Pawn";
    }
    public boolean isLegalMove(Locations loc, Board state){
        Location src = loc.getSrc();
        Location dst = loc.getDst();

//        int i = src.getY();
//        int j = src.getX();
        int x = src.getY() - dst.getY();// TODO: I = Y AND J = X!
        int y = src.getX() - dst.getX();

        if (this.isFirstMove){
            this.isFirstMove = false;
             if ((Math.abs(x) == 1 || Math.abs(x) == 2) && Math.abs(y) == 0 && state.getState()[dst.getX()][dst.getY()] == null){
                 return true;
             }
        }

        // Check if movement of pawn is in the correct direction
        if (this.color.equals("WHITE") && x < 0){
            return false;
        }
        else if (this.color.equals("BLACK") && x > 0){
            return false;
        }
        // Check the move is only one cell front and zero or one cell in diagonal
        if (Math.abs(x) != 1 || Math.abs(y) > 1){
            return false;
        }
        // If moving in diagonal check that there is an enemy piece at destination place
        if(Math.abs(y) == 1 && this.color.equals(state.getState()[dst.getX()][dst.getY()].getColor())){
            return false;
        }
        return true;
    }
    //todo: if it reached to the other side should be replaced with another piece

}
