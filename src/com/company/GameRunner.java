package com.company;

public class GameRunner {
    private Boardgame bg;
    private IO io;
    private GUI gui;
    private DB db;
    private String nameOfGame;
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

        //io.write("top 5 Players: \n" + db.getBestPlayers(this.nameOfGame)); //TODO: NOT FOR EVERY GAME
        io.write("list Of Games: \n" + db.getGames()); //TODO: does not work
        //this.nameOfGame = io.read(); //TODO: does not work
        this.nameOfGame = "chess"; // todo: ^ delete after io.read() ^
        // todo: check if game in list of games
        this.bg = new Boardgame(io,this.nameOfGame);
        this.run();
    }

    public void run()
    {
        bg.initialize(gui);
        //decideFirstPlayer();
        while(!bg.isGameOver()){
            Player p = bg.getNextPlayer();
            p.makeMove(bg.getState());
        }
        io.write(bg.announceWinner()+" won!");
        io.write("enter your name: ");
        String name = io.read();
        db.addWin(this.nameOfGame, name);
        // todo: exit or choose another game
    }

}
