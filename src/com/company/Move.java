package com.company;

import java.util.ArrayList;
import java.util.List;

public class Move {
//    private Player player;
    private Location src;
    private Location dst;
    private List<PieceWithLocation> piecesMoved = new ArrayList<PieceWithLocation>();
    private List<PieceWithLocation> piecesKilled = new ArrayList<PieceWithLocation>();
    private List<PieceWithLocation> piecesAdded = new ArrayList<PieceWithLocation>();
    private boolean MoreMoves = false;
    //private boolean castlingMove = false;

    public Move(/*Player player,*/ Location src, Location dst)
    {
//        this.player = player;
        this.src = src;
        this.dst = dst;
        //this.pieceMoved = src.getPiece();
    }

    public Move(/*Player player,*/ Locations loc)
    {
//        this.player = player;
        this.src = loc.getSrc();
        this.dst = loc.getDst();
        //this.pieceMoved = src.getPiece();
    }

    public void setMoreMoves(boolean bool){this.MoreMoves = bool;}
    public boolean hasMoreMoves(){return MoreMoves;}
    public void addToKillList(PieceWithLocation p){}

//    public boolean isCastlingMove()
//    {
//        return this.castlingMove;
//    }
//
//    public void setCastlingMove(boolean castlingMove)
//    {
//        this.castlingMove = castlingMove;
//    }
}