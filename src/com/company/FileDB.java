package com.company;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileDB extends DB{
//    private static FileDB single_instance = null;
//    private File playersReader;
//    private File gamesReader;
//    private Hashtable<String, ArrayList<User>> BestPlayers = new Hashtable<String, ArrayList<User>>();
//    private final List<String> games = new ArrayList<String>();
//    private final String playerTxt = "best_players";
//
//    /**
//     * private constructor of singleton
//     */
//    private FileDB() {
//        this.playersReader = new File(this.playerTxt + ".txt");
//        this.gamesReader = new File("games.txt");
//        if (!this.playersReader.exists()){
//            try
//            {
//                this.playersReader.createNewFile(); // = File.createTempFile(this.playerTxt, ".txt");
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
//        this.readDb();
//        int a = 0;
//    }
//
//    /**
//     * @return the single instance of file db
//     */
//    // Static method to create instance of Singleton class
//    public static DB getInstance()
//    {
//        if (single_instance == null) {
//            single_instance = new FileDB();
//        }
//        return single_instance;
//    }

    private static volatile DB single_instance = null;
    private File playersReader;
    private File gamesReader;
    private Hashtable<String, ArrayList<User>> BestPlayers = new Hashtable<String, ArrayList<User>>();
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
        int a = 0;
    }

    /**
     * @return the single instance of file db
     */
    // Static method to create instance of Singleton class
    public static DB getInstance()
    {
        DB result = single_instance;
        if (single_instance == null) {
            synchronized (FileDB.class)
            {
                result = single_instance;
                if (result == null)
                {
                    single_instance = result = new FileDB();
                }
            }
        }
        return result;
    }


    /**
     * Read database and save informations locally
     */
    private void readDb(){
        try {
            Scanner reader = new Scanner(this.playersReader);

            while (reader.hasNextLine()) {
                String game = reader.nextLine().toLowerCase();
                this.BestPlayers.put(game, new ArrayList<User>());
                ArrayList<User> current = this.BestPlayers.get(game);
                String data = reader.nextLine();
                if (data.equals("\n")){continue;}
                while (!data.equals("=")) {
                    String[] tokens = data.split(" ");
                    current.add(new User(tokens[0].toUpperCase(), Integer.parseInt(tokens[1])));
                    data = reader.nextLine();
                }
                this.BestPlayers.put(game, this.sortBestPlayers(this.BestPlayers.get(game)));
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
                this.BestPlayers.computeIfAbsent(game.toLowerCase(), k -> new ArrayList<User>());
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
    public List<User> getBestPlayers(String game)
    {
        int size = this.BestPlayers.get(game).size();
        if (size > 5) {size = 5; }
        return this.BestPlayers.get(game).subList(0, size);
    }

    /**
     * Add a win to a specific game
     * @param game the game with a win
     * @param name the name of the player
     */
    public void addWin(String game, String name) {
        boolean modified = false;
        ArrayList<User> bestplayers = this.BestPlayers.get(game);
        //todo: if game is not initialize + name should be all caps
        for (int i = 0; i < bestplayers.size(); i++){
            if(bestplayers.get(i).getName().equals(name.toUpperCase())){
                bestplayers.get(i).setWins(bestplayers.get(i).getWins()+1);
                modified = true;
            }
        }
        if (!modified){
            bestplayers.add(new User(name.toUpperCase(), 1));
        }
        this.BestPlayers.put(game, this.sortBestPlayers(this.BestPlayers.get(game)));
        this.writeDb();
    }

    /**
     * Save local db for next time
     */
    public void writeDb() {
        try {
            FileWriter dbWriter = new FileWriter( this.playersReader, false);
            for (String game : this.BestPlayers.keySet()) {
                dbWriter.write(game.toLowerCase() + "\n");
                ArrayList<User> bestplayers = this.BestPlayers.get(game);
                for (int i = 0; i < bestplayers.size(); i++){
                    String toWrite = bestplayers.get(i).getName() + " " + bestplayers.get(i).getWins() + "\n";
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

    private ArrayList<User> sortBestPlayers(ArrayList<User> bestplayers){
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < bestplayers.size() - 1; i++) {
                User first = bestplayers.get(i);
                User second = bestplayers.get(i+1);
                if (first.getWins() < second.getWins()) {
                    bestplayers.set(i, second);
                    bestplayers.set(i+1, first);
                    sorted = false;
                }
            }
        }
        return bestplayers;
    }
}
