package com.company;

public abstract class GUI implements Observer{
    protected Piece[][] board;
    protected boolean drawCoordination = true; //todo: switch according to the game
    public abstract void draw(Piece[][] board);
    public abstract void flush();


    @Override
    public void update(Piece[][] board){
        this.board = board;
        this.flush(); //todo: make it work
        this.draw(board);
    }
}
