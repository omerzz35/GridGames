package com.company;

import java.util.Locale;

public class GameFactory {

    public GameFactory(){}

    public static AbstractGame getGame(String nameOfGame, IO io)
    {
        switch (nameOfGame.toLowerCase())
        {
            case "chess":
                return new Chess(io);
            case "reversi":
                return new Reversi(io);
            default:
                return null;

        }
    }
}
