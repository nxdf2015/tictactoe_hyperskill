package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String grid = scanner.nextLine();
        Board board = new Board(grid);
        Game game = new Game(board);
        game.showBoard();

        int row,col;
        while(true) {

             try {
                 System.out.print("Enter the coordinates: ");
                 String[]  line = scanner.nextLine().split(" ");

                 col = Integer.parseInt(line[0]);
                 row = Integer.parseInt(line[1]);

                 if (!game.isValidPosition(row,col) ){
                     System.out.println("Coordinates should be from 1 to 3!");
                 }
                 if (!game.isValidCell(row, col)) {
                     System.out.println("This cell is occupied! Choose another one!\n");
                 } else {
                    break;
                 }
             }
             catch (Exception e){

                 System.out.println("You should enter numbers!");
             }
        }

        game.play(row,col);


    }
}
