package pl.kamilsieczkowski.utils;

import java.util.Random;
import java.util.Scanner;

public class Insert {
    private char selected;

    /**
     *
     * @param board - is an array with 9 characters used as board for game
     * @param crossOrCircle - character X or O to add into the board
     * @return - changed board with inserted X or O
     */
    public char[] insertCrosses(char[] board, char crossOrCircle) {
        System.out.println("type number, where you want to insert a cross:");
        int crossInsertPlace = typeNumberToInsert();
        selected = board[crossInsertPlace];
        while (selected == 'X' || selected == 'O') {
            System.out.println("select other place");
            crossInsertPlace = typeNumberToInsert();
            selected = board[crossInsertPlace];
        }
        board = addCrossOrCircleToBoard(board, crossInsertPlace, crossOrCircle);
        return board;
    }

    /**
     * method allows to insert a number on printed board and converts to array place
     * @return array place
     */
    int typeNumberToInsert() {
        Scanner scanner = new Scanner(System.in);
        int crossInsertPlace = scanner.nextInt() - 1;
        return crossInsertPlace;
    }

    /**
     *
     * @param board - is an array with 9 characters used as board for game
     * @return - is an array with inserted circle by computer
     */
    public char[] computerOpponentInsertingCircles(char[] board) {
        Random random = new Random();
        int circeInsertPlace = random.nextInt(8);
        selected = board[circeInsertPlace];
        while (selected == 'X' || selected == 'O') {
            circeInsertPlace = random.nextInt(8);
            selected = board[circeInsertPlace];
        }
        return addCrossOrCircleToBoard(board, circeInsertPlace, 'O');
    }

    /**
     * changing board and adds a character (X or O)
     * @param board - is an array with 9 characters used as board for game
     * @param arrayPlace - place of array to inserts a crossOrCircle
     * @param crossOrCircle - character (X or O)
     * @return - changed board
     */
    char[] addCrossOrCircleToBoard(char[] board, int arrayPlace, char crossOrCircle) {
        board[arrayPlace] = crossOrCircle;
        return board;
    }
    /**
     * medium Lvl
     * @param board- is an array with 9 characters used as board for game
     * @return - is an array with inserted circle by computer
     */
    public char[] computerOpponentInsertCirclesMediumLvl(char[] board) {
        Check check = new Check();
        char a1 = board[0];
        char a2 = board[1];
        char a3 = board[2];
        char b1 = board[3];
        char b2 = board[4];
        char b3 = board[5];
        char c1 = board[6];
        char c2 = board[7];
        char c3 = board[8];
        if (check.computerCheckMedium(a1, a2, 'O') && board[2] != 'X' && board[2] != 'O') {
            board[2] = 'O';
        } else if (check.computerCheckMedium(a2, a3, 'O') && board[0] != 'X' && board[0] != 'O') {
            board[0] = 'O';
        } else if (check.computerCheckMedium(a1, a3, 'O') && board[1] != 'X' && board[1] != 'O') {
            board[1] = 'O';
        } else if (check.computerCheckMedium(b1, b2, 'O') && board[5] != 'X' && board[5] != 'O') {
            board[5] = 'O';
        } else if (check.computerCheckMedium(b2, b3, 'O') && board[3] != 'X' && board[3] != 'O') {
            board[3] = 'O';
        } else if (check.computerCheckMedium(b1, b3, 'O') && board[4] != 'X' && board[4] != 'O') {
            board[4] = 'O';
        } else if (check.computerCheckMedium(c1, c2, 'O') && board[8] != 'X' && board[8] != 'O') {
            board[8] = 'O';
        } else if (check.computerCheckMedium(c2, c3, 'O') && board[6] != 'X' && board[6] != 'O') {
            board[6] = 'O';
        } else if (check.computerCheckMedium(c1, c3, 'O') && board[7] != 'X' && board[7] != 'O') {
            board[7] = 'O';
        } else if (check.computerCheckMedium(a1, b1, 'O') && board[6] != 'X' && board[6] != 'O') {
            board[6] = 'O';
        } else if (check.computerCheckMedium(c1, b1, 'O') && board[0] != 'X' && board[0] != 'O') {
            board[0] = 'O';
        } else if (check.computerCheckMedium(c1, a1, 'O') && board[3] != 'X' && board[3] != 'O') {
            board[3] = 'O';
        } else if (check.computerCheckMedium(a2, b2, 'O') && board[7] != 'X' && board[7] != 'O') {
            board[7] = 'O';
        } else if (check.computerCheckMedium(a2, c2, 'O') && board[4] != 'X' && board[4] != 'O') {
            board[4] = 'O';
        } else if (check.computerCheckMedium(b2, c2, 'O') && board[1] != 'X' && board[1] != 'O') {
            board[1] = 'O';
        } else if (check.computerCheckMedium(a3, b3, 'O') && board[8] != 'X' && board[8] != 'O') {
            board[8] = 'O';
        } else if (check.computerCheckMedium(a3, c3, 'O') && board[5] != 'X' && board[5] != 'O') {
            board[5] = 'O';
        } else if (check.computerCheckMedium(b3, c3, 'O') && board[2] != 'X' && board[2] != 'O') {
            board[2] = 'O';
        } else if (check.computerCheckMedium(a1, b2, 'O') && board[8] != 'X' && board[8] != 'O') {
            board[8] = 'O';
        } else if (check.computerCheckMedium(c3, b2, 'O') && board[0] != 'X' && board[0] != 'O') {
            board[0] = 'O';
        } else if (check.computerCheckMedium(c3, a1, 'O') && board[4] != 'X' && board[4] != 'O') {
            board[4] = 'O';
        } else if (check.computerCheckMedium(a3, b2, 'O') && board[6] != 'X' && board[6] != 'O') {
            board[6] = 'O';
        } else if (check.computerCheckMedium(c1, b2, 'O') && board[2] != 'X' && board[2] != 'O') {
            board[2] = 'O';
        } else if (check.computerCheckMedium(c1, a3, 'O') && board[4] != 'X' && board[4] != 'O') {
            board[4] = 'O';
        } else {
            board = computerOpponentInsertingCircles(board);
        }
        System.out.println("Computer insert circle, your turn...");
        return board;
    }
    /**
     * Hell Lvl
     * @param board- is an array with 9 characters used as board for game
     * @return - is an array with inserted circle by computer
     */
    public char[] computerOpponentInsertCirclesHellLvl(char[] board) {
        Check check = new Check();
        char a1 = board[0];
        char a2 = board[1];
        char a3 = board[2];
        char b1 = board[3];
        char b2 = board[4];
        char b3 = board[5];
        char c1 = board[6];
        char c2 = board[7];
        char c3 = board[8];
        if (check.computerCheckMedium(a1, a2, 'X') && board[2] != 'X' && board[2] != 'O') {
            board[2] = 'O';
        } else if (check.computerCheckMedium(a2, a3, 'X') && board[0] != 'X' && board[0] != 'O') {
            board[0] = 'O';
        } else if (check.computerCheckMedium(a1, a3, 'X') && board[1] != 'X' && board[1] != 'O') {
            board[1] = 'O';
        } else if (check.computerCheckMedium(b1, b2, 'X') && board[5] != 'X' && board[5] != 'O') {
            board[5] = 'O';
        } else if (check.computerCheckMedium(b2, b3, 'X') && board[3] != 'X' && board[3] != 'O') {
            board[3] = 'O';
        } else if (check.computerCheckMedium(b1, b3, 'X') && board[4] != 'X' && board[4] != 'O') {
            board[4] = 'O';
        } else if (check.computerCheckMedium(c1, c2, 'X') && board[8] != 'X' && board[8] != 'O') {
            board[8] = 'O';
        } else if (check.computerCheckMedium(c2, c3, 'X') && board[6] != 'X' && board[6] != 'O') {
            board[6] = 'O';
        } else if (check.computerCheckMedium(c1, c3, 'X') && board[7] != 'X' && board[7] != 'O') {
            board[7] = 'O';
        } else if (check.computerCheckMedium(a1, b1, 'X') && board[6] != 'X' && board[6] != 'O') {
            board[6] = 'O';
        } else if (check.computerCheckMedium(c1, b1, 'X') && board[0] != 'X' && board[0] != 'O') {
            board[0] = 'O';
        } else if (check.computerCheckMedium(c1, a1, 'X') && board[3] != 'X' && board[3] != 'O') {
            board[3] = 'O';
        } else if (check.computerCheckMedium(a2, b2, 'X') && board[7] != 'X' && board[7] != 'O') {
            board[7] = 'O';
        } else if (check.computerCheckMedium(a2, c2, 'X') && board[4] != 'X' && board[4] != 'O') {
            board[4] = 'O';
        } else if (check.computerCheckMedium(b2, c2, 'X') && board[1] != 'X' && board[1] != 'O') {
            board[1] = 'O';
        } else if (check.computerCheckMedium(a3, b3, 'X') && board[8] != 'X' && board[8] != 'O') {
            board[8] = 'O';
        } else if (check.computerCheckMedium(a3, c3, 'X') && board[5] != 'X' && board[5] != 'O') {
            board[5] = 'O';
        } else if (check.computerCheckMedium(b3, c3, 'X') && board[2] != 'X' && board[2] != 'O') {
            board[2] = 'O';
        } else if (check.computerCheckMedium(a1, b2, 'X') && board[8] != 'X' && board[8] != 'O') {
            board[8] = 'O';
        } else if (check.computerCheckMedium(c3, b2, 'X') && board[0] != 'X' && board[0] != 'O') {
            board[0] = 'O';
        } else if (check.computerCheckMedium(c3, a1, 'X') && board[4] != 'X' && board[4] != 'O') {
            board[4] = 'O';
        } else if (check.computerCheckMedium(a3, b2, 'X') && board[6] != 'X' && board[6] != 'O') {
            board[6] = 'O';
        } else if (check.computerCheckMedium(c1, b2, 'X') && board[2] != 'X' && board[2] != 'O') {
            board[2] = 'O';
        } else if (check.computerCheckMedium(c1, a3, 'X') && board[4] != 'X' && board[4] != 'O') {
            board[4] = 'O';
        } else {
            board = computerOpponentInsertCirclesMediumLvl(board);
        }
        return board;
    }
}
