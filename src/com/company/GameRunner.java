package com.company;

public class GameRunner {
    Boardgame bg;
    IO io;
    GUI gui;
    DB db;
//    public GameRunner()
//    {
//        this.bg = new bg(...);
//    }

    public GameRunner(IO io, GUI gui, DB db) {
        this.io = io;
        this.db = db;
        this.gui = gui;
    }

    public void Start()
    {
        // DB TOP 5 and  LIST OF GAMES (NAMES) and PVP (ONLINE OR LOCAL) PVE
        // IO NAME OF GAME
        io.write("top 5 Players: \n" + db.getBestPlayers());
        io.write("list Of Games: \n" + db.getGames());
        String nameOfGame = io.read();
        // todo: check if game in list of games
        this.bg = new Boardgame(io,nameOfGame); //
    }

    public void run()
    {
        bg.initialize(); //*
        //decideFirstPlayer();
        while(!bg.isGameOver()){
            Player p = bg.getNextPlayer();
            p.makeMove(bg.getState());
        }
        io.write(bg.announceWinner()+" won!");
        // todo: enter name to add one more win
    }

}
