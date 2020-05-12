package utils;
import java.util.*;

public class Board {

    private Square[][] board;
    private int bombsCount;
    private int size;


    public Board(int size, int bombsCount) {
        this.size = size;
        this.bombsCount = bombsCount;
        board = new Square[size][size];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Square();
            }
        }
        setBombs();
    }


    /*
    a) Uzupełnij metodę setBombs tak, aby na losowych kwadratach
    z board[][] ustawiała bombę, czyli przypisywało polu status "o".
    (board[x][y].setStatus). Pól z bombami ma być tyle ile podaje
    parametr bombsCount.
     */

    private void setBombs() {
        Random generator = new Random();

        for (int i = 0; i< bombsCount; i++) {
            int x = generator.nextInt(board.length);
            int y = generator.nextInt(board.length);
            board[x][y].setStatus("o");
        }
    }


    public void printBoard() {
        System.out.println("#########BOARD#######");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                    System.out.print(" " + board[i][j].getStatus() + " ");

            }
            System.out.println();
        }
        System.out.println("######################");
    }

    public Square[][] getBoard() {
        return board;
    }

}
