package com.company;

public class GameFactory {
    public static AbstractGame getGame(String nameOfGame, IO io)
    {
        switch (nameOfGame)
        {
            case "chess":
                return new Chess(io);
            default:
                return null;

        }
    }
}
