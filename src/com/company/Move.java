package com.company;

import java.util.ArrayList;
import java.util.List;

public class Move {
//    private Player player;
//    private Location src;
//    private Location dst;
    private List<PieceWithLocations> piecesMoved = new ArrayList<PieceWithLocations>();
    private List<PieceWithLocation> piecesKilled = new ArrayList<PieceWithLocation>();
    private List<PieceWithLocation> piecesAdded = new ArrayList<PieceWithLocation>();
    private boolean MoreMoves = false;
    private boolean isInitialized = false;
    //private boolean castlingMove = false;

    public Move(){}

    public Move(Piece piece, Location src, Location dst)
    {
//        this.player = player;
//        this.src = src;
//        this.dst = dst;
        piecesMoved.add(new PieceWithLocations(piece, new Locations(src, dst)));
        this.isInitialized = true;
        //this.pieceMoved = src.getPiece();
    }

    public Move(Piece piece, Locations loc)
    {
//        this.player = player;
//        this.src = loc.getSrc();
//        this.dst = loc.getDst();
        piecesMoved.add(new PieceWithLocations(piece, loc));
        //this.pieceMoved = src.getPiece();
        this.isInitialized = true;
    }

    public void setMoreMoves(boolean bool){this.MoreMoves = bool;}
    public boolean hasMoreMoves(){return MoreMoves;}
    public void addToKillList(PieceWithLocation p){}

    public List<PieceWithLocations> getPiecesMoved() {
        return piecesMoved;
    }

    public List<PieceWithLocation> getPiecesKilled() {
        return piecesKilled;
    }

    public List<PieceWithLocation> getPiecesAdded() {
        return piecesAdded;
    }

    public void setMove(Piece piece, Locations loc)
    {
        piecesMoved.add(new PieceWithLocations(piece, loc));
        this.isInitialized = true;
    }

    public boolean isInitialized() {
        return isInitialized;
    }
}