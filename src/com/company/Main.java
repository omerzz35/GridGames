package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("start");
        GameRunner game = new GameRunner(new ConsoleIO(), new ConsoleGUI(), FileDB.getInstance()); // todo: check
        game.Start();
    }
}
