package com.company;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private List<PieceWithLocations> piecesMoved = new ArrayList<PieceWithLocations>();
    private List<PieceWithLocation> piecesKilled = new ArrayList<PieceWithLocation>();
    private List<PieceWithLocation> piecesAdded = new ArrayList<PieceWithLocation>();
    private boolean MoreMoves = false;
    private boolean isInitialized = false;

    public Move(){}

    public Move(Piece piece, Location src, Location dst)
    {
        piecesMoved.add(new PieceWithLocations(piece, new Locations(src, dst)));
        this.isInitialized = true;
    }

    public Move(Piece piece, Locations loc)
    {
        piecesMoved.add(new PieceWithLocations(piece, loc));
        this.isInitialized = true;
    }

    public void setMoreMoves(boolean bool){this.MoreMoves = bool;}
    public boolean hasMoreMoves(){return MoreMoves;}

    public void addToKillList(PieceWithLocation p){piecesKilled.add(p);}
    public void addToMoveList(PieceWithLocations p){piecesMoved.add(p);}
    public void addToAddList(PieceWithLocation p){piecesAdded.add(p);}

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

    public void setAddMove(Piece piece, Location loc)
    {
        piecesAdded.add(new PieceWithLocation(piece, loc));
        this.isInitialized = true;
    }
    public boolean isInitialized() {
        return isInitialized;
    }
}