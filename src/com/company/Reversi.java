package com.company;

public class Reversi extends AbstractGame {
    private static final String BLACK = "Black";
    private static final String WHITE = "White";
    private ReversiDisk BlackDisk = new ReversiDisk(BLACK);
    private ReversiDisk WhiteDisk = new ReversiDisk(WHITE); // TODO CHECK IF ALL OF THE DISKS SHOULD BE THE SAME
    //private Hashtable<Character, Integer> my_dict = new Hashtable<Character, Integer>();
    private String nameOfGame = "Chess";

    public Reversi(IO io) {
        super(io);
        this.nameOfGame = "Reversi";
    }

    public BoardAndColors initialize()
    {
        Piece board[][] = {{null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,BlackDisk,WhiteDisk,null,null,null},
                {null,null,null,WhiteDisk,BlackDisk,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null}};
        String colors[] = new String[2];
        colors[0] = WHITE;
        colors[1] = BLACK;
        return new BoardAndColors(new Board(board) ,colors);
    }
    public boolean isGameOver(Board board)
    {
        Piece[][] state = board.getState();
        int sizeX = state[0].length;
        int sizeY = state.length;
        int blackCounter=0,whiteCounter=0;
        for (int i = 0; i < sizeY; i++)
        {
            for (int j = 0; j < sizeX; j++)
            {
                if (state[i][j] != null) {
                    // index = 0 if king's color is white, 1 if king's color is black
                    if (state[i][j].getColor().equals(WHITE))
                    {
                        whiteCounter++;
                    }
                    else // black
                    {
                        blackCounter++;
                    }
                }
            }
        }
        return (whiteCounter == 0|| blackCounter == 0 || blackCounter + whiteCounter == sizeX * sizeY);
    }

    public String howToMove(String color) {//how to play (dice or Square selection etc...) - Press Enter to throw the dice / choose source square and destination square / choose square to put piece
        String src;
        boolean flag = false;
        while (true) {
            this.io.write("Select a square to place the disk:");
            while (true) {
                this.io.write("Player " + color);
                this.io.write("Select square");
                src = io.read().toLowerCase();
                if (src.length() == 2 && !((src.charAt(0) >= 'a' && src.charAt(0) <= 'h') && (src.charAt(1) >= '1' && src.charAt(1) <= '8'))) {
                    this.io.write("Illegal input - try again");
                    continue;
                } else if (src.length() != 2) {
                    this.io.write("Illegal input - try again");
                    continue;
                }
                break;
            }
            return src;
        }
    }

    public boolean rules(String input,Board state,String color,Move move) {// set in move vals
        Piece[][] board = state.getState();
        int i = input.charAt(0) - 'a';
        int j = input.charAt(1) - '1';
        Locations loc = new Locations(new Location(j,i),null);
        if (board[i][j] != null) {this.io.write("There is disk at the square"); return false;}
        Piece pieceColor = null;
        if (color.equals(WHITE))
        {
            pieceColor = WhiteDisk;
        }
        else // black
        {
            pieceColor = BlackDisk;
        }
        if (!pieceColor.isLegalMove(loc,state, false)) {this.io.write("Illegal move"); return false;}
        if (!move.isInitialized())
        {
            move.setAddMove(pieceColor, loc.getSrc());
            Piece[][] tempState = state.getState().clone();
            tempState[i][j] = pieceColor;
            applyMoveAllDirections(move, loc.getSrc(), tempState);
            //change color of tow col and dig
        }
        return true;
    }

    private void applyMoveAllDirections(Move move, Location loc ,Piece[][] state)
    {
        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                if (i == 0 && j == 0)
                {
                    continue;
                }
                applyMove(j, i, loc, move, state);
            }
        }
    }

    private void applyMove(int x, int y, Location loc, Move move, Piece[][] state)
    {
        int sizeX = state[0].length - 1;
        int sizeY = state.length - 1;
        int i = loc.getY();
        int j = loc.getX();
        int a = i, b = j;
        int t = -1;
        while (true)
        {
            t++;
            a += y;
            b += x;
            if (a < 0 || a > sizeY || b < 0 || b > sizeX) {return;}
            if(state[a][b] == null){return;}
            else
            {
                if(state[a][b].getColor() == state[i][j].getColor())
                {
                    break;
                }
            }
        }
        a = i;
        b = j;
        for (int k = 0; k < t; k++)
        {
            a += y;
            b += x;
            Location l = new Location(b, a);
            move.addToKillList(new PieceWithLocation(state[a][b],l));
            move.addToAddList(new PieceWithLocation(state[i][j],l));
        }
    }

    @Override
    public boolean shouldSDrawCoordination() {
        return true;
    }

}
