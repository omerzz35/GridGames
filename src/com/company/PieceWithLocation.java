package com.company;

public class PieceWithLocation {
    private Piece piece;
    private Location location;

    /**
     * constructor
     * @param piece piece object
     * @param location location of the piece
     */
    public PieceWithLocation(Piece piece, Location location) {
        this.piece = piece;
        this.location = location;
    }

    /**
     * @param piece piece object
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * @param location location object
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * accessor
     * @return piece member
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * accessor
     * @return location member
     */
    public Location getLocation() {
        return location;
    }
}
