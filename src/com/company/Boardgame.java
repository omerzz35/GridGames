package com.company;

public class Boardgame {
    private AbstractGame game;
//    private Map<String,AbstractGame> nameToGame = new HashMap(); // make hashmap from name to obj from file of possible games

    public Boardgame(IO io,String nameOfGame)//,...)
    {
//        nameToGame.put("chess" , new Chess(io));
//        this.game = nameToGame.get(nameOfGame);// from nameToGame get game and pass IO and ...
// todo: check if in declaration it is initialize the obj
        GameFactory gf = new GameFactory();
        this.game = gf.getGame(nameOfGame ,io);
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
