package com.company;

public class Person extends Player{

    /**
     * @param gameRules - game rules
     * @param color - the color of the pieces
     * constructor
     */
    public Person(Rules gameRules, String color) {
        super(gameRules, color);
    }

    public String howToMove(Board state)
    {
        return gameRules.howToMove(this.color);
    }
}
