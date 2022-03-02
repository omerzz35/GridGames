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
    private Hashtable<String, Integer> BestPlayers = new Hashtable<String, Integer>();
    private final List<String> games = new ArrayList<String>();
    private final String playerTxt = "best_players";

    private FileDB() {
        this.playersReader = new File(this.playerTxt + ".txt");
        this.gamesReader = new File("games.txt");
        if (!this.playersReader.exists()){
            try
            {
                this.playersReader = File.createTempFile(this.playerTxt, ".txt");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    // Static method to create instance of Singleton class
    public static DB getInstance()
    {
        if (single_instance == null) {
            single_instance = new FileDB();
        }
        return single_instance;
    }

    public void readDb(){
        try {
            Scanner reader = new Scanner(this.playersReader);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] tokens = data.split(" ");
                this.BestPlayers.put(tokens[0], Integer.valueOf(tokens[1]));
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
                this.games.add(game);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public Hashtable<String, Integer> getBestPlayers(){
        return this.BestPlayers;
    }

    public void addWin(String name){
        if(this.BestPlayers.containsKey(name)){
            this.BestPlayers.put(name, this.BestPlayers.get(name) + 1);
        }
        else{
            this.BestPlayers.put(name, 1);
        }
    }

    public void writeDb() {
        try {
            FileWriter dbWriter = new FileWriter(this.playerTxt + ".txt", false);
            for (String key : this.BestPlayers.keySet()) {
                String toWrite = key + this.BestPlayers.get(key).toString() + "\n";
                dbWriter.write(toWrite);
            }
            dbWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
