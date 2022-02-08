package com.company;

public class GameRunner {
    Boardgame bg;
//    public GameRunner()
//    {
//        this.bg = new bg(...);
//    }

    public void Start()
    {
        // DB TOP 5 and  LIST OF GAMES (NAMES) and PVP (ONLINE OR LOCAL) PVE
        // IO NAME OF GAME
        this.bg = new bg(...); //
    }

    public void run()
    {
        bg.initialize(); //*
        while(!isGameOver){
            p = getNextPlayer();
            p.makeMove();
        }
    }

}
