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

    public GameRunner(IO io, GUI gui, DB db) {
        this.io = io;
        this.db = db;
        this.gui = gui;
    }

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
            io.write("top 5 Players: \n" + db.getBestPlayers(this.nameOfGame));
//            for (String name : db.getBestPlayers(this.nameOfGame).keySet() ){
//                io.write(name + " " + db.getBestPlayers(this.nameOfGame).get(name));
//            }
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
