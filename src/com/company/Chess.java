package com.company;

import java.util.ArrayList;
import java.util.List;

public class Chess extends AbstractGame{
    private static final String BLACK = "Black";
    private static final String WHITE = "White";
    private String nameOfGame = "Chess";

    /**
     * @param io -io
     * constructor
     */
    public Chess(IO io) {
        super(io);
        this.nameOfGame = "Chess";
    }

    /**
     * @return BoardAndColors the initialized board and the colors of the
     * players (number of players according to the size of the array)
     */
    public BoardAndColors initialize() {
        Piece board[][] = {{new Rook(BLACK),new Knight(BLACK),new Bishop(BLACK),new Queen(BLACK),new King(BLACK),new Bishop(BLACK),new Knight(BLACK),new Rook(BLACK)},
                {new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK)},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE)},
                {new Rook(WHITE),new Knight(WHITE),new Bishop(WHITE),new Queen(WHITE),new King(WHITE),new Bishop(WHITE),new Knight(WHITE),new Rook(WHITE)}};
        String colors[] = new String[2];
        colors[0] = WHITE;
        colors[1] = BLACK;
        return new BoardAndColors(new Board(board) ,colors);
    }

    /**
     * @param board - the state of the board
     * @return boolean is game over
     */
    public boolean isGameOver(Board board) {
        Piece[] kings = new Piece[2];
        Location[] kingsLoc = new Location[2];
        ArrayList<Location>[] possibleMoves = new ArrayList[2];
        ArrayList<Board>[] possibleBoards = new ArrayList[2];
        Piece[][] tmp_state = board.deepCopyState();
        List<Piece> pieceList = new ArrayList<Piece>();
        List<Location> pieceLocations = new ArrayList<Location>();

        // iterating over the board to get all pieces locations
        int size = tmp_state[0].length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tmp_state[i][j] instanceof King) {
                    // index = 0 if king's color is white, 1 if king's color is black
                    int index = tmp_state[i][j].getColor().equals(WHITE) ? 0 : 1;
                    kings[index] = tmp_state[i][j];
                    kingsLoc[index] = new Location(j, i);
                } else if (tmp_state[i][j] != null) { //if there is a piece saving it
                    pieceList.add(tmp_state[i][j]);
                    pieceLocations.add(new Location(j, i));
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
                    int dstX = kingsLoc[idx].getX() + j;
                    int dstY = kingsLoc[idx].getY() + i;
                    if (dstX >= 0 && dstY >= 0 && dstX < size && dstY < size) {
                        if (tmp_state[dstY][dstX] != null && tmp_state[dstY][dstX].getColor().equals(color)) {
                            if (i != 0 || j != 0){
                                continue;
                            }
                        }
                        possibleMoves[idx].add(new Location(dstX, dstY)); // adding new possible location to list
                        // we also need a temporary state with potential new state after move
                        Piece[][] tmpState = tmp_state.clone();
                        tmpState[kingsLoc[idx].getY()][kingsLoc[idx].getX()] = null;
                        tmpState[dstY][dstX] = kings[idx];
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
            for (int j = 0 ; j < possibleMoves[color].size() ; j++) {
                Board potential = possibleBoards[color].get(j);
                Location loc = possibleMoves[color].get(j);
                if (piece.isLegalMove(new Locations(pieceLocations.get(i), loc), potential, true)) {
                    // if the piece can eat our king after it's potential move, this move is no more an option
                    possibleMoves[color].remove(loc);
                }
            }
        }

        // if one of the kings does not have any more move without being eaten the game is over
        return possibleMoves[0].isEmpty() || possibleMoves[1].isEmpty();
    }


    /**
     * @param color the color of the player that needs to make the move
     * @return string that represents the move
     */
    public String howToMove(String color) {
        String src, dst;
        boolean flag = false;
        while (true)
        {
            this.io.write("select source square and destination square (press x to start over):");
            while (true)
            {
                this.io.write("Player " + color);
                this.io.write("Select source square");
                src = io.read().toLowerCase();
                if (isInputValid(src)){//(src.length() == 2 && !((src.charAt(0) >= 'a' && src.charAt(0) <= 'h') && (src.charAt(1) >= '1' && src.charAt(1) <= '8'))) {
                    this.io.write("Illegal input - try again");
                    continue;
                }
                else if (src.length() == 1 && (src.charAt(0) == 'x' || src.charAt(0) == 'X'))
                {
                    flag = true;
                }
                else if (src.length() == 0 || src.length() == 1 || src.length() > 2)
                {
                    continue;
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
                this.io.write("Select destination square");
                dst = io.read().toLowerCase();
                if (isInputValid(dst)){ //dst.length() == 2 && !((dst.charAt(0) >= 'a' && dst.charAt(0) <= 'h') && (dst.charAt(1) >= '1' && dst.charAt(1) <= '8'))) {
                    this.io.write("Illegal input - try again");
                    continue;
                }
                else if (dst.length() == 1 && (dst.charAt(0) == 'x'))
                {
                    flag = true;
                }
                else if (dst.length() == 0  || dst.length() == 1 || dst.length() > 2)
                {
                    continue;
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

    /**
     * @param input - the string that represents the move
     * @param state - state of the board
     * @param color - the color of the player that needs to make the move
     * @param move - the object of move that contains information of what should change in the board
     * @return boolean - should make more move/s?
     */
    public boolean rules(String input,Board state,String color,Move move) {// set in move vals
        int i1, j1, i2, j2;
        Piece[][] board = state.getState();
        i1 = input.charAt(0) - 'a';
        j1 = input.charAt(1) - '1';
        i2 = input.charAt(3) - 'a';
        j2 = input.charAt(4) - '1';
        Locations loc = new Locations(new Location(j1,i1),new Location(j2,i2));
        if (board[i1][j1] == null) {this.io.write("There is no piece at the source square"); return false;}
        if (board[i1][j1].getColor() != color) {this.io.write("it is not your piece"); return false;}
        if (!board[i1][j1].isLegalMove(loc,state, false)) {this.io.write("Illegal move"); return false;}
        if (board[i2][j2] != null)
        {
            if (board[i2][j2].getColor() == color){this.io.write("Illegal move"); return false;}
            if (!move.isInitialized()){move.setMove(board[i1][j1], loc);}
            move.addToKillList(new PieceWithLocation(board[i2][j2],loc.getDst()));
        }
        else
        {
            if (!move.isInitialized())
            {
                move.setMove(board[i1][j1], loc);
            }
        }
        return true;
    }

    /**
     * @return should draw the coordination (like 12... and ab...)
     */
    @Override
    public boolean shouldSDrawCoordination() {
        return true;
    }

    /**
     * @param board - state of the board
     * @return - the winner
     */
    public String announceWinner(Board board)
    {
        Piece[] kings = new Piece[2];
        Location[] kingsLoc = new Location[2];
        ArrayList<Location>[] possibleMoves = new ArrayList[2];
        ArrayList<Board>[] possibleBoards = new ArrayList[2];
        Piece[][] state = board.getState().clone();
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
                    kingsLoc[index] = new Location(j, i);
                } else if (state[i][j] != null) { //if there is a piece saving it
                    pieceList.add(state[i][j]);
                    pieceLocations.add(new Location(j, i));
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
                    int dstX = kingsLoc[idx].getX() + j;
                    int dstY = kingsLoc[idx].getY() + i;
                    if (dstX >= 0 && dstY >= 0 && dstX < size && dstY < size) {
                        if (state[dstY][dstX] != null && state[dstY][dstX].getColor().equals(color)) {
                            if (i != 0 || j != 0){
                                continue;
                            }
                        }
                        possibleMoves[idx].add(new Location(dstX, dstY)); // adding new possible location to list
                        // we also need a temporary state with potential new state after move
                        Piece[][] tmpState = state.clone();
                        tmpState[kingsLoc[idx].getY()][kingsLoc[idx].getX()] = null;
                        tmpState[dstY][dstX] = kings[idx];
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
            for (int j = 0 ; j < possibleMoves[color].size() ; j++) {
                Board potential = possibleBoards[color].get(j);
                Location loc = possibleMoves[color].get(j);
                if (piece.isLegalMove(new Locations(pieceLocations.get(i), loc), potential, true)) {
                    // if the piece can eat our king after it's potential move, this move is no more an option
                    possibleMoves[color].remove(loc);
                }
            }
        }

        // if one of the kings does not have any more move without being eaten the game is over
        // index = 0 if king's color is white, 1 if king's color is black
        if (possibleMoves[0].isEmpty() && !possibleMoves[1].isEmpty()){return BLACK.toUpperCase();}
        else if (!possibleMoves[0].isEmpty() && possibleMoves[1].isEmpty()){return WHITE.toUpperCase();}
        else {return "DRAW";}
    }

    private boolean isInputValid(String input)
    {
        return (input.length() == 2 && !((input.charAt(0) >= 'a' && input.charAt(0) <= 'h') && (input.charAt(1) >= '1' && input.charAt(1) <= '8')));
    }
}