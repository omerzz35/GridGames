package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board implements Observable{
    private List<Observer> observers;
    private Piece[][] board; // null = empty

    public Board(Piece[][] board){
        this.board = board;
        observers = new ArrayList<Observer>();
    }

    public Piece[][] getState(){
        return this.board;
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(board, "Board");
        }
    }

    public void changeValue(Piece[][] board) {
        this.board = board;
        this.notifyObservers();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

}
