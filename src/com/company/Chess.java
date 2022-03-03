package com.company;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Chess extends AbstractGame{
    private static final String BLACK = "Black";
    private static final String WHITE = "White";
    private String nameOfGame = "Chess";

    public Chess(IO io) {
        super(io);
        this.nameOfGame = "Chess";
    }

    public BoardAndColors initialize()
    {
        // io.w...
        Piece board[][] = {{new Rook(BLACK),new Knight(BLACK),new Bishop(BLACK),new Queen(BLACK),new King(BLACK),new Bishop(BLACK),new Knight(BLACK),new Rook(BLACK)},
                {new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK)},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE)},
                {new Rook(WHITE),new Knight(WHITE),new Bishop(WHITE),new Queen(WHITE),new King(WHITE),new Bishop(WHITE),new Knight(WHITE),new Rook(WHITE)}};
        String colors[] = new String[2];
        colors[0] = WHITE;
        colors[1] = BLACK;
        return new BoardAndColors(new Board(board) ,colors);
    }

    public boolean isGameOver(Board board) {
        Piece[] kings = new Piece[2];
        Location[] kingsLoc = new Location[2];
        ArrayList<Location>[] possibleMoves = new ArrayList[2];
        ArrayList<Board>[] possibleBoards = new ArrayList[2];
        Piece[][] state = board.getState();
        List<Piece> pieceList = new ArrayList<Piece>();
        List<Location> pieceLocations = new ArrayList<Location>();

        // iterating over the board to get all pieces locations
        int size = state[0].length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (state[i][j] instanceof King) {
                    // index = 0 if king's color is white, 1 if king's color is black
                    int index = state[i][j].getColor().equals(WHITE) ? 0 : 1;
                    kings[index] = state[i][j];
                    kingsLoc[index] = new Location(i, j);
                } else if (state[i][j] != null) { //if there is a piece saving it
                    pieceList.add(state[i][j]);
                    pieceLocations.add(new Location(i, j));
                }

            }
        }

        // for each king, establishing all his potential moves (including actual state). NOT USING IS_LEGAL_MOVE
        // METHOD because it will cause infinite loop
        for (int idx = 0; idx < 2; idx++) {
            String color = (idx == 0) ? WHITE : BLACK;
            possibleMoves[idx] = new ArrayList<Location>(); //for each king possible move
            possibleBoards[idx] = new ArrayList<Board>(); //for each king state of possible move
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int dstX = kingsLoc[idx].getX() + i;
                    int dstY = kingsLoc[idx].getY() + j;
                    if (dstX > 0 && dstY > 0 && dstX < size && dstY < size) {
                        if (state[dstX][dstY] != null && state[dstX][dstY].getColor().equals(color)) {
                            continue;
                        }
                        possibleMoves[idx].add(new Location(dstX, dstY)); // adding new possible location to list
                        // we also need a temporary state with potential new state after move
                        Piece[][] tmpState = state.clone();
                        tmpState[kingsLoc[idx].getX()][kingsLoc[idx].getY()] = null;
                        tmpState[dstX][dstY] = kings[idx];
                        possibleBoards[idx].add(new Board(tmpState)); // adding potential state to possible boards
                    }
                }
            }
        }

        // for all possible move of the king (including actual state) we are checking if an enemy can eat it.
        for (int i = 0; i < pieceList.size(); i++) {
            Piece piece = pieceList.get(i);
            // if the color is white we want to check black king possible moves, same in reverse case
            int color = (piece.getColor().equals(WHITE)) ? 1 : 0;
            for (Location loc : possibleMoves[color]) {
                Board potential = possibleBoards[color].get(i);
                if (piece.isLegalMove(new Locations(pieceLocations.get(i), loc), potential)) {
                    // if the piece can eat our king after it's potential move, this move is no more an option
                    possibleMoves[color].remove(loc);
                }
            }
        }

        // if one of the kings does not have any more move without being eaten the game is over
        return possibleMoves[0].isEmpty() || possibleMoves[1].isEmpty();

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
            if (move == null){move = new Move(board[i1][j1], loc);}
            move.addToKillList(new PieceWithLocation(board[i2][j2],loc.getDst()));
        }
        else
        {
            if (move == null){move = new Move(board[i1][j1], loc);}
        }
        return true;
    }
}
