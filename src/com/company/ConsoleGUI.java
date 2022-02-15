package com.company;

public class ConsoleGUI extends GUI{
    //white : ♔ king, ♕ queen, ♖ rook, ♗ bishop, ♘ knight and ♙ pawn
    //black : ♚ king, ♛ queen, ♜ rook, ♝ bishop, ♞ knight and ♟ pawn

    // todo: observer
    //https://stackoverflow.com/questions/50895577/printing-chess-board-with-unicodes
//    public void print(){
//        System.out.print("(#1)(#2)(#3)(#4)(#5)(#6)(#7)(#8)");
//        for(int i = 0 ; i < 8; i++ ) {
//            for (int j = 0; j < 8; j++) {
//                if (j == 0) {
//                    System.out.println();
//                    System.out.print("(" + Character.toString((char) (i+'A')) + ")");
//                }
//                if (!Board.getInstance().getTiles()[i][j].isOccupied()) {
//                    System.out.print("[ ]");
//                } else {
//                    System.out.print("["+ PieceSymbolFactory
//                            .getSymbol(Board.getInstance().getTiles()[i][j].getPiece()) + "]");
//                }
//            }
//        }
//    }
}
