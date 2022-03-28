package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class ConsoleGUI extends GUI {
    private Hashtable<String, String> piecesToIcon = new Hashtable<String, String>();
    private File piecesToIconFile;// = new File("piecesToIcon.txt");

    /**
     * makes the console gui
     * constructor
     */
    public ConsoleGUI(String piecesToIconFileName) {
        this.piecesToIconFile = new File(piecesToIconFileName);
        this.piecesToIcon = new Hashtable<String, String>();

        try {
            Scanner reader = new Scanner(this.piecesToIconFile);
            while (reader.hasNextLine()) {
                String  pti = reader.nextLine(); //pieces to icon
                String[] tokens = pti.split(" ");
                piecesToIcon.put(tokens[0],tokens[1]);
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * flushes the console
     */
    public void flush(){
        System.out.flush();
    }

    /**
     * @param board the board that needs to be represented on the gui
     */
    public void draw(Piece[][] board) {
        this.board = board;
        if (drawCoordination) {
            this.DrawBorder();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (drawCoordination && j == 0) {
                    System.out.println();
                    System.out.print("(" + Character.toString((char) (i + 'A')) + ")");
                }
                else if (j == 0 && i != 0){
                    System.out.println();
                }
                if (board[i][j] == null) {
                    System.out.print("[ᅟ]");//char is :"ᅟ"
                } else { // not null
                    String temp = "";
                    temp += board[i][j].getColor() + board[i][j].getName();
                    System.out.print("[" + piecesToIcon.get(temp) + "]");
                }
            }
        }
        System.out.println();
    }

    private void DrawBorder()
    {
        for (int i = 0; i < board.length; i++) {
            System.out.print("(#" + (i + 1) + ")");
        }
    }
}

