package com.company;

public class Board {
    private Piece[][] board; // null = empty
    public Board(Piece[][] board){this.board = board;}

    public Piece[][] getState(){return this.board;}

}
