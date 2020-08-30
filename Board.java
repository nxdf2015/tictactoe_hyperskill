package tictactoe;

public class Board {
    private char[][] board;
    private int countFree ;

    public Board(String grid) {
        this.board = new char[3][3];
        this.countFree = 0;

        for(int i = 0; i < grid.length();i++){
            char c = grid.charAt(i);
            countFree += c == '_' || c== ' ' ? 1 : 0;
            board[i / 3][i % 3] = c;
        }
    }


    public String render() {
        String header = "-".repeat(9);
        String rep = header + System.lineSeparator();
        for(int row = 0; row < 3;row++){
            String line = "| ";
            for(int col = 0; col < 3 ; col++){
                line += board[row][col] + " ";
            }
            line += "|" + System.lineSeparator();
            rep += line;

        }
        rep += header + System.lineSeparator();
        return rep;
    }

    public boolean isFree(int row, int col) {
        return board[row][col] == '_';
    }

    public void set(int row, int col, char player) {
        if (board[row][col] == '_' ){
            countFree--;
        }
        board[row][col] = player;
    }

    public char get(int row, int col) {
        return board[row][col];
    }

    public int getFreeCell() {
        return countFree;
    }

    public char getPlayer() {
        int  x = 0, o = 0;
        for(int row = 0;row <3;row++){
            for(int col =0;col<3;col++){
                if (get(row,col) == 'X'){
                    x++;
                }
                else if (get(row,col) == 'O'){
                    o++;
                }
            }
        }
        return x == o ? 'X' : 'O';
    }
}
