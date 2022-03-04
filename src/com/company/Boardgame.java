package com.company;

public class Boardgame {
    private AbstractGame game;
    private int turn = -1, numOfPlayers;
    private Player players[];
    private IO io;

    // private Map<String,AbstractGame> nameToGame = new HashMap(); // make hashmap from name to obj from file of possible games
    //private String nameOfGame;
    private Board board;
    public Boardgame(IO io,String nameOfGame)
    {
        // nameToGame.put("chess" , new Chess(io));
        // this.game = nameToGame.get(nameOfGame);// from nameToGame get game and pass IO and ...
        // todo: check if in declaration it is initialize the obj
        this.io = io;
        GameFactory gf = new GameFactory();
        this.game = gf.getGame(nameOfGame ,io);
        int i = 0;
    }

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
                String bot = io.read();
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
    }

    public boolean isGameOver()
    {
        return this.game.isGameOver(board);
    }

    public Player getNextPlayer()
    {
        turn = (turn + 1) % numOfPlayers;
        return players[turn];
    }

    public Board getState()
    {
        return this.board;
    }

    public String announceWinner()
    {
        return this.players[turn].getColor();
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
