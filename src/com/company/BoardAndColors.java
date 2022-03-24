package com.company;

public class BoardAndColors {
    private Board board;
    private String[] colors;

    /**
     * @param board - array of Pieces
     * @param colors - list of strings of colors
     * constructor
     */
    public BoardAndColors(Board board, String[] colors) {
        this.board = board;
        this.colors = colors;
    }

    /**
     * @return board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @return list of string of colors
     */
    public String[] getColors() {
        return colors;
    }
}
