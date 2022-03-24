package com.company;

public class Locations {
    private Location src, dst;

    /**
     * @param src source Location
     * @param dst destination Location
     * constructor
     */
    public Locations(Location src,Location dst)
    {
        this.src = src;
        this.dst = dst;
    }

    /**
     * @return source Location
     */
    public Location getSrc() { return src; }

    /**
     * @return destination Location
     */
    public Location getDst() {
        return dst;
    }

    /**
     * @param src source Location
     * set source Location
     */
    public void setSrc(Location src) {
        this.src = src;
    }

    /**
     * @param dst destination Location
     * set destination Location
     */
    public void setDst(Location dst) {
        this.dst = dst;
    }
}
