package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class ConsoleGUI extends GUI {
    //white : ♔ king, ♕ queen, ♖ rook, ♗ bishop, ♘ knight and ♙ pawn
    //black : ♚ king, ♛ queen, ♜ rook, ♝ bishop, ♞ knight and ♟ pawn
    private Hashtable<String, String> piecesToIcon = new Hashtable<String, String>();
    private File piecesToIconFile = new File("piecesToIcon.txt");

    public ConsoleGUI() {
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


//        piecesToIcon.put("WKing", "♔");
//        piecesToIcon.put("WQueen", "♕");
//        piecesToIcon.put("WRook", "♖");
//        piecesToIcon.put("WBishop", "♗");
//        piecesToIcon.put("WKnight", "♘");
//        piecesToIcon.put("WPawn", "♙");
//        piecesToIcon.put("BKing", "♚");
//        piecesToIcon.put("BQueen", "♛");
//        piecesToIcon.put("BRook", "♜");
//        piecesToIcon.put("BBishop", "♝");
//        piecesToIcon.put("BKnight", "♞");
//        piecesToIcon.put("BPawn", "♟");
    }


    //https://stackoverflow.com/questions/50895577/printing-chess-board-with-unicodes

    public void flush(){
        System.out.flush();
    }

    public void draw(Piece[][] board) {
        this.board = board;
        if (drawCoordination) {
            for (int i = 0; i < board.length; i++) {
                System.out.print("(#" + (i + 1) + ")"); //todo: check if it should be io....
            }

        }
        //System.out.print("(#1)(#2)(#3)(#4)(#5)(#6)(#7)(#8)");
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
//                    if (board[i][j].getColor() == "Black") {
////                        temp.concat("B");
//                        temp += "B";
//                    } else {
////                        temp.concat("W");
//                        temp += "W";
//                    }
//                    temp.concat(board[i][j].getName());
                    temp += board[i][j].getColor() + board[i][j].getName();
                    System.out.print("[" + piecesToIcon.get(temp) + "]");
                }
            }
        }
        System.out.println();
    }
}

