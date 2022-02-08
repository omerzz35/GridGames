package com.company;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.function.Function;

public class Player {
    private Function howToMove;
    private Function rules;
    private Piece[] pieces;

    public  Player(howToMove,rules){}

    public void makeMove()
    {
        while(true)
        {
            Locations loc = howToMove(); //how to play (dice or Square selection etc...) - Press Enter to throw the dice / choose source square and destination square
            int len = pieces.length;
            Piece piece = null;
            boolean flag = true;
            //check witch piece
            for(int i = 0; i<len; i++){
                if (pieces[i].getLocation() == loc.getSrc()) {flag=false;piece = pieces[i];}
            }
            if (flag){System.out.println("Illegal move"); continue;}//Illegal move (src was not found)
            if (!piece.isLegalMove(loc.getDst())){System.out.println("Illegal move"); continue;}//Illegal move (dst is not legal)
            //todo:update board
            if (rules(loc)) {break;} //if rules(loc)==true break else one more turn
        }
    }



}
