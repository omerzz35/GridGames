package com.company;

public class ReversiDisk extends Piece{
    public ReversiDisk(String color) {
        this.color = color;
        this.name = "ReversiDisk";
    }

    public boolean isLegalMove(Locations loc, Board state, boolean gameOver){
        int j = loc.getSrc().getX();
        int i = loc.getSrc().getY();
        int sizeX = state.getState()[0].length;
        int sizeY = state.getState().length;
        for (int y = -1; y <= 1; y++)
        {
            for (int x = -1; x <= 1; x++)
            {
                int a = i + y;
                int b = j + x;
                if (a < 0 || a > sizeY || b < 0 || b > sizeX) {continue;}
                if(state.getState()[a][b] != null)
                {
                    if (y == 0 && x == 0)
                    {
                        continue;
                    }
                    else
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
