package com.company;

import java.util.Arrays;
import java.util.Locale;
import java.lang.Object;

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

        while (true)
        {
            io.write("list Of Games: \n" + db.getGames());
            while (true)
            {
                io.write("Which game ?");
                this.nameOfGame = io.read().toLowerCase();
                if (db.getGames().contains(this.nameOfGame))
                {
                    break;
                }
                else
                {
                    io.write("the game is not exist, try again");
                }
            }
            //this.nameOfGame = "Chess"; // todo: ^ delete after io.read() ^
            // todo: check if game in list of games
            this.bg = new Boardgame(io,this.nameOfGame);
            this.run();
            io.write("top 5 Players: \n" + db.getBestPlayers(this.nameOfGame)); //TODO: sort and ...
            try
            {
                wait(5000);
            }
            catch (Exception e)
            {

            }
            String exit;
            while (true)
            {
                io.write("press enter to continue or x to exit");
                exit = io.read().toLowerCase();
                if (exit.length() == 0 || exit == "x"){break;}
            }
            if (exit == ""){break;}
        }


    }

    public void run()
    {
        bg.initialize(gui);
        //decideFirstPlayer();
        // gui.update(this.bg.getState().getState());
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
