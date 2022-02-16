package com.company;

public class PieceWithLocation {
    private Piece piece;
    private Location location;

    public PieceWithLocation(Piece piece, Location location) {
        this.piece = piece;
        this.location = location;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Piece getPiece() {
        return piece;
    }

    public Location getLocation() {
        return location;
    }
}
