package com.company;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private List<PieceWithLocations> piecesMoved = new ArrayList<PieceWithLocations>();
    private List<PieceWithLocation> piecesKilled = new ArrayList<PieceWithLocation>();
    private List<PieceWithLocation> piecesAdded = new ArrayList<PieceWithLocation>();
    private boolean MoreMoves = false;
    private boolean isInitialized = false;

    /**
     * constructor
     */
    public Move(){}

    /**
     * @param piece - the piece that moved
     * @param src - source Location
     * @param dst - destination Location
     * constructor (and isInitialized = true)
     */
    public Move(Piece piece, Location src, Location dst)
    {
        piecesMoved.add(new PieceWithLocations(piece, new Locations(src, dst)));
        this.isInitialized = true;
    }

    /**
     * @param piece - the piece that moved
     * @param loc - source and destination Locations
     * constructor (and isInitialized = true)
     */
    public Move(Piece piece, Locations loc)
    {
        piecesMoved.add(new PieceWithLocations(piece, loc));
        this.isInitialized = true;
    }

    /**
     * @param bool - set more moves (true = needs to make more move/s false = o.w)
     */
    public void setMoreMoves(boolean bool){this.MoreMoves = bool;}

    /**
     * @return has more moves
     */
    public boolean hasMoreMoves(){return MoreMoves;}

    /**
     * @param p - PieceWithLocation
     * add piece to kill list
     */
    public void addToKillList(PieceWithLocation p){piecesKilled.add(p);}

    /**
     * @param p - PieceWithLocations
     * add piece to move list
     */
    public void addToMoveList(PieceWithLocations p){piecesMoved.add(p);}

    /**
     * @param p - PieceWithLocation
     * add piece to move list
     */
    public void addToAddList(PieceWithLocation p){piecesAdded.add(p);}

    /**
     * @return List of PieceWithLocations of the pieces that needs to be moved
     */
    public List<PieceWithLocations> getPiecesMoved() {
        return piecesMoved;
    }

    /**
     * @return List of PieceWithLocation of the pieces that needs to be killed
     */
    public List<PieceWithLocation> getPiecesKilled() {
        return piecesKilled;
    }

    /**
     * @return List of PieceWithLocation of the pieces that needs to be added
     */
    public List<PieceWithLocation> getPiecesAdded() {
        return piecesAdded;
    }

    /**
     * @param piece piece
     * @param loc - Locations
     * initialize / update the move object (move func)
     */
    public void setMove(Piece piece, Locations loc)
    {
        piecesMoved.add(new PieceWithLocations(piece, loc));
        this.isInitialized = true;
    }

    /**
     * @param piece piece
     * @param loc - Location
     * initialize / update the move object (add func)
     */
    public void setAddMove(Piece piece, Location loc)
    {
        piecesAdded.add(new PieceWithLocation(piece, loc));
        this.isInitialized = true;
    }

    /**
     * @return is move object initialized (not "null")
     */
    public boolean isInitialized() {
        return isInitialized;
    }
}