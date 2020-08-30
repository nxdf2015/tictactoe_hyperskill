package tictactoe;

public class Game {
    private Board board;
    char player;
    public Game(Board board) {
        this.board = board;

    }


    public void showBoard() {
        System.out.println(board.render());
    }

    public void play(int row, int col) {
        row = 3 - row ;
        col = col - 1;
        player = board.getPlayer();

        board.set(row ,col ,player);
        System.out.println(board.render());
        if ( isWin(row,col)){
            System.out.println(player + " wins");
        }
        else if (board.getFreeCell() == 0){
            System.out.println("Draw");
        }
        else {
            System.out.println("Game not finished");
        }
    }
    private boolean rowWin(int row){
        for(int c = 0; c <3 ; c++){
            if (board.get(row,c) != player){
                return false;
            }
        }
        return true;
    }
    private boolean isWin(int row,int col){

       return rowWin(row) || colWin(col) || diagWin(row,col);

    }



    private boolean diagWin(int row, int col) {
       if (!(row == col  || row +col == 2)){
           return false;
       }

        if ( row == col  ){
            for (int i = 0 ; i < 3 ; i++){
                if (board.get(i,i) != player) {
                    return false;
                }
            }
        }
       if (row + col == 2){
            for (int r  = 0;r  < 3;r++){
                if(board.get(r, 2-r) != player){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean colWin(int col) {

        for(int r = 0; r <3 ; r++){
             if (board.get(r ,col) != player){
                return false;
            }
        }
        return true;
    }

    public boolean isValidCell(int row,int col){

        row = 3 - row ;
        col = col - 1;
        return board.isFree(row,col);
    }

    public boolean isValidPosition(int row, int col) {
        return (1 <= row && row <= 3) &&  (1 <= col && col <= 3);
    }
}
