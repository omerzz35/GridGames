package com.company;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.function.Function;

public abstract class Player {
    protected Rules gameRules;
    protected String color;

    public  Player(Rules gameRules, String color){this.gameRules = gameRules;this.color = color;}

    public String getColor(){return this.color;}

    public abstract void makeMove(Board state);
}
