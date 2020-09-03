package gamePlay.inserters;

import gameBoard.GameBoard;

import java.util.Random;
import java.util.Scanner;

public class Inserter {
    private char selected;

    public char[] insertCrosses(char[] board) {
        System.out.println("type number, where you want to insert a cross:");
        int crossInsertPlace = typeNumberToInsert();
        selected = board[crossInsertPlace];
        while (selected == 'X' || selected == 'O') {
            System.out.println("select other place");
            crossInsertPlace = typeNumberToInsert();
            selected = board[crossInsertPlace];
        }
        board = addCrossOrCircleToBoard(board, crossInsertPlace, 'X');
        return board;
    }
    int typeNumberToInsert (){
        Scanner scanner = new Scanner(System.in);
        int crossInsertPlace = scanner.nextInt() - 1;
        return crossInsertPlace;
    }

    public char[] computerOpponentInsertingCircles(char[] board) {
        Random random = new Random();
        int circeInsertPlace = random.nextInt(8);
        selected = board[circeInsertPlace];
        while (selected == 'X' || selected == 'O') {
            circeInsertPlace = random.nextInt(8);
            selected = board[circeInsertPlace];
        }
        int visualisedCircleInsertPlace = circeInsertPlace + 1;
        System.out.println("Computer insert circle at: " + visualisedCircleInsertPlace + " place");
        return addCrossOrCircleToBoard(board, circeInsertPlace, 'O');
    }

    char[] addCrossOrCircleToBoard(char[] board, int arrayPlace, char crossOrCircle) {
        board[arrayPlace] = crossOrCircle;
        GameBoard gameBoard = new GameBoard();
        gameBoard.displayBoard(board);
        return board;
    }
}
