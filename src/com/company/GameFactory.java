package com.company;

import java.util.Locale;

public class GameFactory {

    /**
     * constructor
     */
    public GameFactory(){}

    /**
     * @param nameOfGame - the name of the game
     * @param io -io
     * @return the game
     */
    public static AbstractGame getGame(String nameOfGame, IO io)
    {
        switch (nameOfGame.toLowerCase())
        {
            case "chess":
                return new Chess(io);
            case "reversi":
                return new Reversi(io);
            default:
                //return new Exception("The game does not exist");
                throw new IllegalArgumentException("Not existing game");

        }
    }
}
