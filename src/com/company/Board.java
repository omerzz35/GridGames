package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board implements Observable{
    private List<Observer> observers;
    private Piece[][] board; // null = empty

    /**
     * @param board - array of Pieces
     * constructor
     */
    public Board(Piece[][] board){
        this.board = board;
        observers = new ArrayList<Observer>();
    }

    /**
     * @return state of board
     */
    public Piece[][] getState(){
        return this.board;
    }

    /**
     * notify all observers about a move
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(board);
        }
    }

    /**
     * @param move - contains the data to execute the move
     * execute the move (update the board and notify the gui)
     */
    public void exe(Move move) {
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
        this.changeValue();
    }

    /**
     * @param board
     * update the board and notify the gui (all of the Observers)
     */
    public void changeValue(Piece[][] board) {
        this.board = board;
        this.notifyObservers();
    }

    /**
     * notify the gui (Observers)
     */
    public void changeValue() {
        this.notifyObservers();
    }

    /**
     * @param observer - observer
     * add observer to observers
     */
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    /**
     * @param observer - observer
     * remove observer from observers
     */
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

}
