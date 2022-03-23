package com.company;

public abstract class GUI implements Observer{
    protected Piece[][] board;
    protected boolean drawCoordination = true;
    public abstract void draw(Piece[][] board);
    public abstract void flush();


    @Override
    public void update(Piece[][] board){
        this.board = board;
        this.flush();
        this.draw(board);
    }

    public void setCoordination(boolean shouldSDraw)
    {
        this.drawCoordination = shouldSDraw;
    }
}
