package com.company;

public class Person extends Player{

    public Person(Rules gameRules, String color) {
        super(gameRules, color);
    }

    public void makeMove(Board state)// game state as an arg (in makeMove get the color / pass pieces)
    {
        Move move = new Move();
        while(true)
        {
            String input = gameRules.howToMove(this.color); //how to play (dice or Square selection etc...) - Press Enter to throw the dice / choose source square and destination square / choose square to put piece
            if (!gameRules.rules(input,state,this.color,move)) {
                continue;
            }
            if (!move.hasMoreMoves()) {break;} // if rules(loc) == true break else one more turn
        }
        state.exe(move);
    }
}
