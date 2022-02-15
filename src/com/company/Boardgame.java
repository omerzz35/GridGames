package com.company;

import java.util.HashMap;
import java.util.Map;

public class Boardgame {
    private AbstractGame game;
    private Map nameToGame = new HashMap(); // make hashmap from name to obj from file of possible games

    public Boardgame(IO io,String nameOfGame,...)
    {
        this.game = // from nameToGame get game and pass IO and ...
    }

//    public enum GameStatus {
//        ACTIVE,
//        BLACK_WIN,
//        WHITE_WIN,
//        FORFEIT,
//        STALEMATE,
//        RESIGNATION
//    }
}
