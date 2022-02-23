package com.company;

import java.util.Hashtable;

public class Chess extends AbstractGame{
    private static final String BLACK = "Black";
    private static final String WHITE = "White";
    private String nameOfGame = "Chess";

    public Chess(IO io) {
        super(io);
        this.nameOfGame = "Chess";
    }

    public void initialize()
    {
        // todo: need to return arrs of pieces (for each player)
        Piece board[][] = {{new Rook(BLACK),new Knight(BLACK),new Bishop(BLACK),new Queen(BLACK),new King(BLACK),new Bishop(BLACK),new Knight(BLACK),new Rook(BLACK)},
                {new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK)},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE)},
                {new Rook(WHITE),new Knight(WHITE),new Bishop(WHITE),new Queen(WHITE),new King(WHITE),new Bishop(WHITE),new Knight(WHITE),new Rook(WHITE)}};
    }
//    public Player getNextPlayer(){}
    public boolean isGameOver(Board board){
        Piece[][] kings = new Piece[2][1];
        state = board.getState();
        for(int i=0 ; i<8 ; i++){
            for(int j=0 ; j<8 ; j++){
                if(state[i][j] instanceof King){
                    index = state[i][j].getColor().equals("WHITE") ? 0 : 1;
                    kings[index][0] = state[i][j];
                }
            }
        }
        for(int i=0 ; i<8 ; i++){
            for(int j=0 ; j<8 ; j++) {
                if(state[i][j] != null){
                    if (state[i][j].getColor().equals("WHITE")){
                        state[i][j].
                    }
                }
            }
        }
    }

    public String howToMove() {//how to play (dice or Square selection etc...) - Press Enter to throw the dice / choose source square and destination square / choose square to put piece
        String src, dst;
        boolean flag = false;
        while (true)
        {
            this.io.write("select source square and destination square (press x to start over / write \"long castling\" / \" short castling\"  to do castling):");
            while (true)
            {
                this.io.write("select source square");
                src = io.read().toLowerCase();
                if (src == "castling") {return src;} // todo: long or short
                if (!(src.length() == 2 && ((src.charAt(0) >= 'a' && src.charAt(0) <= 'h') || (src.charAt(0) >= 'A' && src.charAt(0) <= 'H')) && (src.charAt(1) >= '1' && src.charAt(1) <= '8'))) { // src[0] == A B C D E F G H - src[1] == 1 2 3 4 5 6 7 8
                    this.io.write("Illegal input - try again");
                }
                else if (src.length() == 1 && (src.charAt(0) == 'x' || src.charAt(0) == 'X'))
                {
                    flag = true;
                }
                break;
            }
            if (flag == true)
            {
                flag = false;
                continue;
            }
            while (true)
            {
                this.io.write("select source square");
                dst = io.read().toLowerCase();
                if (dst == "castling") {return dst;}
                if (!(dst.length() == 2 && ((dst.charAt(0) >= 'a' && dst.charAt(0) <= 'h') || (dst.charAt(0) >= 'A' && dst.charAt(0) <= 'H')) && (dst.charAt(1) >= '1' && dst.charAt(1) <= '8'))) { // dst[0] == A B C D E F G H - dst[1] == 1 2 3 4 5 6 7 8
                    this.io.write("Illegal input - try again");
                }
                else if (dst.length() == 1 && (dst.charAt(0) == 'x' || dst.charAt(0) == 'X'))
                {
                    flag = true;
                }
                break;
            }
            if (flag == true)
            {
                flag = false;
                continue;
            }
            break;
        }
        return src.concat(" ").concat(dst);
    }
    // in how to move check simple things, like location in board (0 <=x,y< board.size)
    public boolean rules(String input,Board state,String color,Move move) {// set in move vals
        if (input == "castling")
        {
            //todo: castling
        }
//        if (move == null){move = new Move()}
        int i1,j1,i2,j2;
        Piece[][] board = state.getState();
        Hashtable<Character, Integer> my_dict = new Hashtable<Character, Integer>();
        my_dict.put('1', 7);
        my_dict.put('2', 6);
        my_dict.put('3', 5);
        my_dict.put('4', 4);
        my_dict.put('5', 3);
        my_dict.put('6', 2);
        my_dict.put('7', 1);
        my_dict.put('8', 0);
        j1 = input.charAt(0) - 'a';
        i1 = my_dict.get(input.charAt(1));
        j2 = input.charAt(3) - 'a';
        i2 = my_dict.get(input.charAt(4));
        Locations loc = new Locations(new Location(j1,i1),new Location(j2,i2));
        if (board[i1][j1] == null) {this.io.write("There is piece at the source square"); return false;}
        if (board[i1][j1].getColor() != color) {this.io.write("it is not your piece"); return false;}
        if (!board[i1][j1].isLegalMove(loc,state)) {this.io.write("Illegal move"); return false;}
        if (board[i2][j2] != null)
        {
            if (board[i2][j2].getColor() == color){this.io.write("Illegal move"); return false;}
            if (move == null){move = new Move(loc);}
            move.addToKillList(new PieceWithLocation(board[i2][j2],loc.getDst()));
        }
        else
        {
            if (move == null){move = new Move(loc);}
        }
        return true;
    }
}
