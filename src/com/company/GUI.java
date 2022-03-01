package com.company;

public abstract class GUI implements Observer{
    protected Piece[][] board;
    protected boolean drawCoordination = true; //todo: switch according to the game
    public abstract void draw();


    @Override
    public void update(Piece[][] board, String name){
        switch (name)
        {
            case "Board":
                this.board = board;
                draw();
            default:
                System.out.println("err");
        }
        System.out.flush();
        this.draw();
    }
}
