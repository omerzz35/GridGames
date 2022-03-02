package com.company;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.function.Function;

public abstract class Player {
    protected Rules gameRules;
//    private Function howToMove;
//    private Function rules;
    protected String color;
//    private Piece[] pieces;

    public  Player(Rules gameRules, String color){this.gameRules = gameRules;this.color = color;}

    public String getColor(){return this.color;}

    public abstract void makeMove(Board state);// game state as an arg (in makeMove get the color / pass pieces)
//    public void makeMove(Board state)// game state as an arg (in makeMove get the color / pass pieces)
//    {
//        Move move =  null;
//        while(true)
//        {
//            // get pieces by color
//            //Piece[] pieces = ....
//            String input = gameRules.howToMove(); //how to play (dice or Square selection etc...) - Press Enter to throw the dice / choose source square and destination square / choose square to put piece
//            // in how to move check simple things, like location in board (0 <=x,y< board.size)
//            if (!gameRules.rules(input,state,this.color,move)) {// set in move vals
//                continue;
//            }
//
////            int len = pieces.length;
////            Piece piece = null;
////            boolean flag = true;
////            //check witch piece
////            for(int i = 0; i<len; i++){
////                if (pieces[i].getLocation() == loc.getSrc()) {flag=false;piece = pieces[i];}
////            }
////            if (flag){System.out.println("Illegal move"); continue;} //Illegal move (src was not found)
////            if (!piece.isLegalMove(loc.getDst())){System.out.println("Illegal move"); continue;}//Illegal move (dst is not legal)
//             //todo:update board (pass move to .... to - update board and ui)
//            if (!move.hasMoreMoves()) {break;} //if rules(loc)==true break else one more turn
//        }
//        board.exe(move);
//    }



}
