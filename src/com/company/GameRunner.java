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

    /**
     * @param io - io
     * @param gui - gui
     * @param db - database
     * constructor
     */
    public GameRunner(IO io, GUI gui, DB db) {
        this.io = io;
        this.db = db;
        this.gui = gui;
    }

    /**
     * starts the game - choose witch game, after the game show top 5 leaderboard
     */
    public void Start()
    {
        while (true)
        {
            io.write("list Of Games: \n" + db.getGames());
            while (true)
            {
                io.write("Which game ?(press x to exit) ");
                this.nameOfGame = io.read().toLowerCase();
                if (this.nameOfGame.equals("x"))
                {
                    return;
                }
                else if (db.getGames().contains(this.nameOfGame))
                {
                    break;
                }
                else
                {
                    io.write("the game is not exist, try again");
                }
            }
            this.bg = new Boardgame(io,this.nameOfGame);
            gui.setCoordination(this.bg.shouldDrawCoordination());
            this.run();
            io.write("Best players table:");
            for (User user : db.getBestPlayers(this.nameOfGame)){
                io.write(user.getName() + " has " + user.getWins() + " wins");
            }
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
                if (exit.length() == 0 || exit.equals("x")){break;}
            }
            if (exit.equals("x")){return;}
        }
    }

    /**
     * runs the game we chose
     */
    public void run()
    {
        bg.initialize(gui);
        while(!bg.isGameOver()){
            Player p = bg.getNextPlayer();
            p.makeMove(bg.getState());
        }
        io.write(bg.announceWinner()+" won!");
        io.write("enter your name: ");
        String name = io.read();
        db.addWin(this.nameOfGame, name);
    }

}
