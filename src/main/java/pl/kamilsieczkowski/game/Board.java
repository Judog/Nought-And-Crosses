package pl.kamilsieczkowski.game;

public class Board {
    char[] board;
/**  Invokes start array used for board game*/
    public char[] setStartBoard() {
        char a1 = '1';
        char a2 = '2';
        char a3 = '3';
        char b1 = '4';
        char b2 = '5';
        char b3 = '6';
        char c1 = '7';
        char c2 = '8';
        char c3 = '9';
        board = new char[]{a1, a2, a3,
                b1, b2, b3,
                c1, c2, c3};
        return board;
    }
/**
 * displays board as 3 columns and 3 rows
 *  @param board is array with 9 characters used as board for game
 * */
    public void displayBoard(char[] board) {
        System.out.print("|");
        for (int i = 1; i <= 9; i++) {
            int arrayCounter = i - 1;
            System.out.print(board[arrayCounter]);
            System.out.print("|");
            if (i % 3 == 0 && i < 9) {
                System.out.println();
                System.out.print("|");
            }
        }
        System.out.println();
    }
}

