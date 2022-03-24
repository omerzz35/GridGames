package com.company;

public class Location {
    private int x,y;

    /**
     * @param x - x Coordination
     * @param y - y Coordination
     * constructor
     */
    public Location(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * @return x Coordination
     */
    public int getX() { return x; }

    /**
     * @return y Coordination
     */
    public int getY() {
        return y;
    }

    /**
     * @param x Coordination
     * set x Coordination
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y Coordination
     * set y Coordination
     */
    public void setY(int y) {
        this.y = y;
    }
}
