package com.company;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class FileDB extends DB{
    private static FileDB single_instance = null;
    private File playersReader;
    private File gamesReader;
    private Hashtable<String, Hashtable<String, Integer>> BestPlayers = new Hashtable<String, Hashtable<String, Integer>>();
    private final List<String> games = new ArrayList<String>();
    private final String playerTxt = "best_players";

    /**
     * private constructor of singleton
     */
    private FileDB() {
        this.playersReader = new File(this.playerTxt + ".txt");
        this.gamesReader = new File("games.txt");
        if (!this.playersReader.exists()){
            try
            {
                this.playersReader.createNewFile(); // = File.createTempFile(this.playerTxt, ".txt");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        this.readDb();
    }

    /**
     * @return the single instance of file db
     */
    // Static method to create instance of Singleton class
    public static DB getInstance()
    {
        if (single_instance == null) {
            single_instance = new FileDB();
        }
        return single_instance;
    }

    /**
     * Read database and save informations locally
     */
    public void readDb(){
        try {
            Scanner reader = new Scanner(this.playersReader);

            while (reader.hasNextLine()) {
                String game = reader.nextLine().toLowerCase();
                this.BestPlayers.put(game, new Hashtable<String, Integer>());
                Hashtable<String, Integer>map = this.BestPlayers.get(game);
                String data = reader.nextLine();
                if (data.equals("\n")){continue;}
                while (!data.equals("=")) {
                    String[] tokens = data.split(" ");
                    map.put(tokens[0], Integer.valueOf(tokens[1]));
                    data = reader.nextLine();
                }
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try {
            Scanner reader = new Scanner(this.gamesReader);
            while (reader.hasNextLine()) {
                String game = reader.nextLine();
                this.games.add(game.toLowerCase());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Get best players of a specific game
     * @param game the game we want best players
     * @return best players
     */
    public Hashtable<String, Integer> getBestPlayers(String game)
    {
        return this.BestPlayers.get(game);
    }

    /**
     * Add a win to a specific game
     * @param game the game with a win
     * @param name the name of the player
     */
    public void addWin(String game, String name) {
        Hashtable<String, Integer> map = this.BestPlayers.get(game);
        if(this.BestPlayers.containsKey(name)){
            map.put(name, map.get(name) + 1);
        }
        else{
            map.put(name, 1);
        }
        this.writeDb();
    }

    /**
     * Save local db for next time
     */
    public void writeDb() {
        try {
            FileWriter dbWriter = new FileWriter( this.playersReader, false);
            for (String game : this.BestPlayers.keySet()) {
                dbWriter.write(game + "\n");
                for (String player : this.BestPlayers.get(game).keySet()) {
                    String toWrite = player + " " + this.BestPlayers.get(game).get(player).toString() + "\n";
                    dbWriter.write(toWrite);
                }
                dbWriter.write("=\n");
            }
            dbWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Return currently playable games
     * @return list of games
     */
    public List<String> getGames(){
        return this.games;
    }
}
