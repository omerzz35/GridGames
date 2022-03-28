package com.company;

public class Pawn extends Piece{
    private boolean isFirstMove;

    /**
     * @param color - the color of the King
     * constructor
     */
    public Pawn(String color){
        this.color = color;
        this.name = "Pawn";
        this.isFirstMove = true;
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
        int dx = dst.getX() - src.getX();
        int dy = dst.getY() - src.getY();

        if (this.isFirstMove){
            if(Math.abs(dy) == 2){
                if(dy <0 && state.getState()[dst.getY()+1][dst.getX()] != null){return false;}
                if(dy >0 && state.getState()[dst.getY()-1][dst.getX()] != null){return false;}
            }
             if (Math.abs(dy) == 1 || Math.abs(dy) == 2) {
                 if (Math.abs(dx) == 0 && state.getState()[dst.getY()][dst.getX()] == null) {
                     if ((this.color.equals("White") && dy < 0) || (this.color.equals("Black") && dy > 0)) {
                         if (!gameOver) {
                             this.isFirstMove = false;
                         }
                         return true;
                     }
                 }
                 if (Math.abs(dy) == 1 && Math.abs(dx) == 1 &&
                         !this.color.equals(state.getState()[dst.getY()][dst.getX()].getColor())) {
                     return (this.color.equals("White") && dy < 0) || (this.color.equals("Black") && dy > 0);
                 }
             return false;
             }
        }

        // Check if movement of pawn is in the correct direction
        if (this.color.equals("White") && dy < 0){
            return false;
        }
        else if (this.color.equals("Black") && dy > 0){
            return false;
        }
        // Check the move is only one cell front and zero or one cell in diagonal
        if (Math.abs(dy) != 1 || Math.abs(dx) > 1){
            return false;
        }
        // If moving in diagonal check that there is an enemy piece at destination place
        if(Math.abs(dx) == 1 && this.color.equals(state.getState()[dst.getY()][dst.getX()].getColor())){
            return false;
        }
        return true;
    }

}
