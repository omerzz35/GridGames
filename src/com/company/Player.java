package com.company;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.function.Function;

public abstract class Player {
    protected Rules gameRules;
    protected String color;

    /**
     * @param gameRules - game rules
     * @param color - color
     */
    public Player(Rules gameRules, String color){this.gameRules = gameRules;this.color = color;}

    /**
     * @return the color of the player
     */
    public String getColor(){return this.color;}

    /**
     * @param state - the state of the board
     * how to mke the move object to be executed
     */
    public abstract void makeMove(Board state);
}
