package com.company;

public interface Observer {
    /**
     * @param board
     * update the board
     */
    void update(Piece[][] board);
}
