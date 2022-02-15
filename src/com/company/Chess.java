package com.company;

public class Chess extends AbstractGame{
    private String nameOfGame = "Chess";

    public void initialize()
    {
        Piece board[][] = {{new Rook("b"),new Knight("b"),new Bishop("b"),new Queen("b"),new King("b"),new Bishop("b"),new Knight("b"),new Rook("b")},
                {new Pawn("b"),new Pawn("b"),new Pawn("b"),new Pawn("b"),new Pawn("b"),new Pawn("b"),new Pawn("b"),new Pawn("b"),new Pawn("b")},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {new Pawn("w"),new Pawn("w"),new Pawn("w"),new Pawn("w"),new Pawn("w"),new Pawn("w"),new Pawn("w"),new Pawn("w"),new Pawn("w")},
                {new Rook("w"),new Knight("w"),new Bishop("w"),new Queen("w"),new King("w"),new Bishop("w"),new Knight("w"),new Rook("w")}};
    }
//    public Player getNextPlayer(){}
    public boolean isGameOver(){}
    howToMove(){io} //how to play (dice or Square selection etc...) - Press Enter to throw the dice / choose source square and destination square / choose square to put piece
    rules(input,pieces,move); // set in move vals
}
