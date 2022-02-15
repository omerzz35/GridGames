package com.company;

public abstract class Piece {
    protected String name;
    protected String color;
//    protected Location location;

    public Location getLocation(){return location;}
    public void setLocation(int x,int y){location.setX(x);location.setY(y);}
    public String getColor(){return color;}
    public abstract boolean isLegalMove(Location loc);
    public IO display(); // should not be here - the gui should get id of piece + color and do it himself
}
