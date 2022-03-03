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
            observer.update(board);
        }
    }

    public void exe(Move move)
    {
        List<PieceWithLocation> piecesKilled =  move.getPiecesKilled();
        List<PieceWithLocations> piecesMoved = move.getPiecesMoved();
        List<PieceWithLocation> piecesAdded = move.getPiecesAdded();
        for (PieceWithLocation pwl: piecesKilled)
        {
            this.board[pwl.getLocation().getY()][pwl.getLocation().getX()] = null;
        }
        for (PieceWithLocations pwls: piecesMoved)
        {
            this.board[pwls.getLocations().getSrc().getY()][pwls.getLocations().getSrc().getX()] = null;
            this.board[pwls.getLocations().getDst().getY()][pwls.getLocations().getDst().getX()] = pwls.getPiece();
        }
        for (PieceWithLocation pwl: piecesAdded)
        {
            this.board[pwl.getLocation().getY()][pwl.getLocation().getX()] = pwl.getPiece();
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
