package com.company;

import java.util.Locale;

public class Boardgame {
    private AbstractGame game;
    private int turn = -1, numOfPlayers;
    private Player players[];
    private IO io;
    private Board board;
    private String currGame;

    /**
     * @param io - io
     * @param nameOfGame - the name of the game
     * constructor - creates the game
     */
    public Boardgame(IO io,String nameOfGame)
    {
        this.currGame = nameOfGame;
        this.io = io;
        //GameFactory gf = new GameFactory();
        this.game = GameFactory.getGame(nameOfGame ,io);
    }

    /**
     * @param gui - The GUI that will be used for the game
     * initialize the board game
     */
    public void initialize(GUI gui)
    {
        BoardAndColors bac = this.game.initialize();
        this.board = bac.getBoard();
        this.board.addObserver(gui);
        String colors[] = bac.getColors();
        this.numOfPlayers = colors.length;
        players = new Player[numOfPlayers];
        players[0] = new Person(this.game,colors[0]);
        for (int i = 0; i < numOfPlayers ; i++)
        {
            while (true){
                io.write("Is Player " + (i + 1) + " a bot ? [yes/no]:");
                String bot = io.read().toLowerCase();
                if (bot.equals("no"))
                {
                    players[i] = new Person(this.game,colors[i]);
                    break;
                }
                else if (bot.equals("yes"))
                {
                    players[i] = new Person(this.game,colors[i]);
                    break;
                    //bot...
                }
                else
                {
                    continue;
                }
            }

        }
        this.board.changeValue();
    }

    /**
     * @return is game over (boolean)
     */
    public boolean isGameOver()
    {
        return this.game.isGameOver(board);
    }

    /**
     * @return the next player
     */
    public Player getNextPlayer()
    {
        turn = (turn + 1) % numOfPlayers;
        return players[turn];
    }

    /**
     * @return the state of the board (as board)
     */
    public Board getState()
    {
        return this.board;
    }

    /**
     * @return the color of the winner
     */
    public String announceWinner()
    {
        return game.announceWinner(this.getState());
        //return this.players[turn].getColor();
    }

    /**
     * @return should draw the coordination (like 12... and ab...)
     */
    public boolean shouldDrawCoordination()
    {
        return game.shouldSDrawCoordination();
    }
}
