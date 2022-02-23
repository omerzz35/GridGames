package com.company;

import java.util.List;

public class Board implements Observable{
    private List<Observer> observers;
    private Piece[][] board; // null = empty
    public Board(Piece[][] board){this.board = board;}

    public Piece[][] getState(){return this.board;}

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(board, "Board");
        }
    }

    @Override
    public void changeValue(Piece[][] board) {
        this.board = board;
        notifyObservers();
    }

}
