package com.company;

public class User {
    private String name;
    private int wins;

    /**
     * constructor
     * @param name name of the user
     * @param wins number of wins
     */
    public User(String name, int wins) {
        this.name = name;
        this.wins = wins;
    }

    /**
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     * @return number of wins of the user
     */
    public int getWins() {
        return wins;
    }

    /**
     * setter
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter
     * @param wins number of wins to set
     */
    public void setWins(int wins) {
        this.wins = wins;
    }
}
