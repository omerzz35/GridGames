package com.company;

import java.util.Hashtable;
import java.util.Scanner;

public class ConsoleGUI extends GUI{
    //white : ♔ king, ♕ queen, ♖ rook, ♗ bishop, ♘ knight and ♙ pawn
    //black : ♚ king, ♛ queen, ♜ rook, ♝ bishop, ♞ knight and ♟ pawn
    private Hashtable<String, String> piecesToIcon = new Hashtable<String, String>();;

    private Move stringToMove(String string){
        if (string.length() != 5) {return null;}
        int[] coords = new int[5];

        for (int i = 0; i < string.length(); i++) {
            if (i == 0 || i == 3){
                coords[i] = string.charAt(i) - 'A';
            }
            else{
                coords[i] = string.charAt(i) - '0';
            }
        }

        for (int i = 0; i < 5 ; i++){
            if (i == 2){continue;}
            if (coords[i] > board.length || coords[i] < 0){return null;}
        }

        Location origin = new Location(coords[0], coords[1]);
        Location destination = new Location(coords[3], coords[4]);

        return new Move(origin, destination);
    }

    public ConsoleGUI() {
        piecesToIcon.put("WKing", "♔");
        piecesToIcon.put("WQueen", "♕");
        piecesToIcon.put("WRook", "♖");
        piecesToIcon.put("WBishop", "♗");
        piecesToIcon.put("WKnight", "♘");
        piecesToIcon.put("WPawn", "♙");
        piecesToIcon.put("BKing", "♚");
        piecesToIcon.put("BQueen", "♛");
        piecesToIcon.put("BRook", "♜");
        piecesToIcon.put("BBishop", "♝");
        piecesToIcon.put("BKnight", "♞");
        piecesToIcon.put("BPawn", "♟");
    }

    // todo: it is just for chess!!!! - need to make it generic (pass piecesToIcon?)
    //https://stackoverflow.com/questions/50895577/printing-chess-board-with-unicodes

    public void draw(){
        if(drawCoordination)
        {
            for (int i = 0; i < board.length; i++)
            {
                System.out.print("(#"+ (i+1) +")");
            }

        }
        //System.out.print("(#1)(#2)(#3)(#4)(#5)(#6)(#7)(#8)");
        for(int i = 0 ; i < board.length; i++ ) {
            for (int j = 0; j < board[0].length; j++) {
                if (drawCoordination && j == 0) {
                    System.out.println();
                    System.out.print("(" + Character.toString((char) (i+'A')) + ")");
                }
                if (board[i][j] == null) {
                    System.out.print("[ ]");
                }
                else { // not null
                    String temp = "";
                    if (board[i][j].getColor() == "Black"){temp.concat("B");}
                    else {temp.concat("W");}
                    temp.concat(board[i][j].getName());
                    System.out.print("["+ piecesToIcon.get(temp) + "]");
                }
            }
        }
    }

    public Move getInput(String player){
        Scanner input = new Scanner(System.in);
        String string = String.format("Next Move for %s", player);
        System.out.println(string);
        System.out.println("Format of Input: Location of you piece [SPACE] Destination\nFor example \"A5 B5\"");
        System.out.print("Your next move is: ");
        String move = input.nextLine();

        Move fromInput = this.stringToMove(move);
        if (fromInput == null){
            System.out.println("\nINCORRECT INPUT");
            return null;
        }
        return fromInput;
    }
}
