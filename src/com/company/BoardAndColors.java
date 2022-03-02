package com.company;

public class BoardAndColors {
    private Board board;
    private String[] colors;

    public BoardAndColors(Board board, String[] colors) {
        this.board = board;
        this.colors = colors;
    }

    public Board getBoard() {
        return board;
    }

    public String[] getColors() {
        return colors;
    }
}
