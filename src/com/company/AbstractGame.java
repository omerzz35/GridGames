package com.company;

public abstract class AbstractGame implements Rules{
    protected IO io;
    public AbstractGame(IO io) {
        this.io = io;
    }

    /**
     * @return BoardAndColors the initialized board and the colors of the
     * players (number of players according to the size of the array)
     */
    public abstract BoardAndColors initialize();

    /**
     * @param board - the state of the board
     * @return boolean is game over
     */
    public abstract boolean isGameOver(Board board);

    /**
     * @param color the color of the player that needs to make the move
     * @return string that represents the move
     * how to play (dice or Square selection etc...) - Press Enter to throw the dice / choose source square and
     * destination square / choose square to put piece
     */
    public abstract String howToMove(String color);

    /**
     * @param input - the string that represents the move
     * @param state - state of the board
     * @param color - the color of the player that needs to make the move
     * @param move - the object of move that contains information of what should change in the board
     * @return boolean - should make more move/s?
     */
    public abstract boolean rules(String input, Board state, String color, Move move); // set values in move

    /**
     * @return should draw the coordination (like 12... and ab...)
     */
    public abstract boolean shouldSDrawCoordination();
}

