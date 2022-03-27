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
     * get input from the person and make the move object for execute
     */
    public void makeMove(Board state)// game state as an arg (in makeMove get the color / pass pieces)
    {
        Move move = new Move();
        while(true)
        {
            String input = howToMove(state);
            if (!gameRules.rules(input,state,this.color,move)) {
                continue;
            }
            if (!move.hasMoreMoves()) {break;} // if rules(loc) == true break else one more turn
        }
        state.exe(move);
    }

    public abstract String howToMove(Board state);

}
