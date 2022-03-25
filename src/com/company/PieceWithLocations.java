package com.company;

public class PieceWithLocations {
    private Piece piece;
    private Locations locations;

    /**
     * constructor
     * @param piece piece object
     * @param locations locations
     */
    public PieceWithLocations(Piece piece, Locations locations) {
        this.piece = piece;
        this.locations = locations;
    }

    /**
     * @param piece piece object
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * @param locations locations object
     */
    public void setLocations(Locations locations) {
        this.locations = locations;
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
     * @return locations member
     */
    public Locations getLocations() {
        return locations;
    }
}
