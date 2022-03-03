package com.company;

public class PieceWithLocations {
    private Piece piece;
    private Locations locations;

    public PieceWithLocations(Piece piece, Locations locations) {
        this.piece = piece;
        this.locations = locations;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    public Piece getPiece() {
        return piece;
    }

    public Locations getLocations() {
        return locations;
    }
}
