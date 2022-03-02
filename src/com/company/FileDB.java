package com.company;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDB extends DB implements {
    private static FileDB single_instance = null;
    private File dfReader = new File("db.txt");
    private List<String[]> BestPlayers;

    private FileDB() {
        if (!dfReader.exists()){
            try
            {
                dfReader = File.createTempFile("db", ".txt");
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
        this.BestPlayers = new ArrayList<String[]>();
        try {
            Scanner reader = new Scanner(this.dfReader);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] tokens = data.split(" ");
                BestPlayers.add(tokens);
            }
            reader.close();
            /// TODO: once db is read return it ?
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public List<String[]> getBestPlayers(){
        return this.BestPlayers;
    }

    public void writeDb(List<String[]> BestPlayers) {
        try {
            FileWriter dbWriter = new FileWriter("db.txt", false);
            for (String[] tokens : BestPlayers) {
                StringBuilder toWrite = new StringBuilder(tokens[0]);
                for (int j = 1; j < tokens.length; j++) {
                    toWrite.append(" ").append(tokens[j]);
                }
                toWrite.append("\n");
                dbWriter.write(toWrite.toString());
            }
            dbWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
