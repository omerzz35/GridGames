package com.company;

public class GameRunner {
    Boardgame bg;
    IO io = new ConsoleIO();
    DB db;
//    public GameRunner()
//    {
//        this.bg = new bg(...);
//    }

    public GameRunner(IO io, DB db) {
        this.io = io;
        this.db = db;
    }

    public void Start()
    {
        // DB TOP 5 and  LIST OF GAMES (NAMES) and PVP (ONLINE OR LOCAL) PVE
        // IO NAME OF GAME
        db.getGames();
        String
        this.bg = new Boardgame(io,nameOfGame); //
    }

    public void run()
    {
        bg.initialize(); //*
        //decideFirstPlayer();
        while(!bg.isGameOver){
            Player p = bg.getNextPlayer();
            // move io
            p.makeMove(bg.getState());
        }
        //announceWinner();
    }

}
