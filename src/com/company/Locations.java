package com.company;

public class Locations {
    private Location src, dst;

    public Locations(Location src,Location dst)
    {
        this.src = src;
        this.dst = dst;
    }

    public Location getSrc() {
        return src;
    }
    public Location getDst() {
        return dst;
    }

    public void setSrc(Location src) {
        this.src = src;
    }

    public void setDst(Location dst) {
        this.dst = dst;
    }
}
