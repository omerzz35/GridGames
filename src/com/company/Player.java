package com.company;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.function.Function;

public class Player {
    private Function howToMove;
    private Function rules;
    String color;
//    private Piece[] pieces;

    public  Player(Function howToMove,Function rules,String color){}

    public void makeMove(Board state)// game state as an arg (in makeMove get the color / pass pieces)
    {
        Move move =  null;
        while(true)
        {
            // get pieces by color
            //Piece[] pieces = ....
            String input = howToMove(); //how to play (dice or Square selection etc...) - Press Enter to throw the dice / choose source square and destination square / choose square to put piece
            // in how to move check simple things, like location in board (0 <=x,y< board.size)
            rules(input,state,this.color,move); // set in move vals

//            int len = pieces.length;
//            Piece piece = null;
//            boolean flag = true;
//            //check witch piece
//            for(int i = 0; i<len; i++){
//                if (pieces[i].getLocation() == loc.getSrc()) {flag=false;piece = pieces[i];}
//            }
//            if (flag){System.out.println("Illegal move"); continue;} //Illegal move (src was not found)
//            if (!piece.isLegalMove(loc.getDst())){System.out.println("Illegal move"); continue;}//Illegal move (dst is not legal)
             //todo:update board (pass move to .... to - update board and ui)
            if (!move.hasMoreMoves()) {break;} //if rules(loc)==true break else one more turn
        }
        board.exe(move);
    }



}
