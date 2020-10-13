package pl.kamilsieczkowski.game;

import static pl.kamilsieczkowski.constants.Constants.*;

public class Board {
    char[] board;

    /**
     * Invokes start array used for board game
     */
    public char[] setStartBoard() {
        board = new char[]{A1, A2, A3,
                B1, B2, B3,
                C1, C2, C3};
        return board;
    }

    /**
     * displays board as 3 columns and 3 rows
     *
     * @param board is array with 9 characters used as board for game
     */
    public void displayBoard(char[] board) {
        System.out.print(PIPE);
        for (int loopCounter = ONE; loopCounter <= NINE; loopCounter++) {
            System.out.print(board[loopCounter - ONE]);
            System.out.print(PIPE);
            if (loopCounter % THREE == ZERO && loopCounter < NINE) {
                System.out.println();
                System.out.print(PIPE);
            }
        }
        System.out.println();
    }
}

