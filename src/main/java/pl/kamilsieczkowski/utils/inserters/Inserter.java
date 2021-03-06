package pl.kamilsieczkowski.utils.inserters;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.checkers.Checker;

import java.util.Random;
import java.util.Scanner;

import static pl.kamilsieczkowski.constants.Constants.*;
import static pl.kamilsieczkowski.constants.Texts.*;

public class Inserter {
    protected char selected;

    /**
     * @param gameBoard     - is an array with 9 characters used as gameBoard for game
     * @param crossOrCircle - character X or O to add into the gameBoard
     * @return - changed gameBoard with inserted X or O
     */
    public char[] insertCrosses(char[] gameBoard, char crossOrCircle) {
        System.out.println(INSERT_A_CROSS);
        int crossInsertPlace = typeNumberToInsert();
        selected = gameBoard[crossInsertPlace];
        while (selected == CROSS || selected == CIRCLE) {
            System.out.println(OTHER_PLACE);
            crossInsertPlace = typeNumberToInsert();
            selected = gameBoard[crossInsertPlace];
        }
        gameBoard = addCrossOrCircleToBoard(gameBoard, crossInsertPlace, crossOrCircle);
        return gameBoard;
    }

    /**
     * method allows to insert a number on printed board and converts to array place
     *
     * @return array place
     */
    int typeNumberToInsert() {
        Scanner scanner = new Scanner(System.in);
        int crossInsertPlace = scanner.nextInt() - ONE;
        return crossInsertPlace;
    }

    /**
     * @param board - is an array with 9 characters used as board for game
     * @return - is an array with inserted circle by computer
     */
    public char[] computerOpponentInsertingCircles(char[] board) {
        Random random = new Random();
        int circeInsertPlace = random.nextInt(EIGHT);
        selected = board[circeInsertPlace];
        while (selected == CROSS || selected == CIRCLE) {
            circeInsertPlace = random.nextInt(EIGHT);
            selected = board[circeInsertPlace];
        }
        return addCrossOrCircleToBoard(board, circeInsertPlace, CIRCLE);
    }

    /**
     * changing board and adds a character (X or O)
     *
     * @param board         - is an array with 9 characters used as board for game
     * @param arrayPlace    - place of array to inserts a crossOrCircle
     * @param crossOrCircle - character (X or O)
     * @return - changed board
     */
    char[] addCrossOrCircleToBoard(char[] board, int arrayPlace, char crossOrCircle) {
        board[arrayPlace] = crossOrCircle;
        return board;
    }

    /**
     * sum of all methods of computers turn on medium level
     *
     * @param gameBoard - is an array with 9 characters used as board for game
     * @return - board after computers turn, on Hell Level
     */
    public char[] computerOpponentInsertingCircleMediumLvl(char[] gameBoard) {
        int sumOfCirclesOnEnteredBoard = checkingSumOfCrossesOrCircles(gameBoard, CIRCLE);
        char[] changedGameBoard = computerOpponentAI(CIRCLE, gameBoard);
        int sumOfCirclesOnChangedBoard = checkingSumOfCrossesOrCircles(changedGameBoard, CIRCLE);
        if (sumOfCirclesOnEnteredBoard != sumOfCirclesOnChangedBoard) {
            gameBoard = changedGameBoard;
        } else {
            gameBoard = computerOpponentInsertingCircles(gameBoard);
        }
        return gameBoard;
    }

    /**
     * sum of all methods of compters turn on hell level
     *
     * @param gameBoard - is an array with 9 characters used as board for game
     * @return - board after computers turn, on Hell Level
     */
    public char[] computerOpponentInsertingCircleHellLvl(char[] gameBoard) {
        int sumOfCirclesOnEnteredBoard = checkingSumOfCrossesOrCircles(gameBoard, CIRCLE);
        char[] changedGameBoard = computerOpponentAI(CIRCLE, gameBoard);
        int sumOfCirclesOnChangedBoard = checkingSumOfCrossesOrCircles(changedGameBoard, CIRCLE);
        char[] secondChangedGameBoard = computerOpponentAI(CROSS, gameBoard);
        int sumOfCirclesOnSecondChangedBoard = checkingSumOfCrossesOrCircles(secondChangedGameBoard, CIRCLE);
        if (sumOfCirclesOnChangedBoard != sumOfCirclesOnEnteredBoard) {
            gameBoard = changedGameBoard;
        } else if (sumOfCirclesOnEnteredBoard != sumOfCirclesOnSecondChangedBoard) {
            gameBoard = secondChangedGameBoard;
        } else {
            gameBoard = computerOpponentInsertingCircles(gameBoard);
        }
        return gameBoard;
    }

    /**
     * @param boardGame     - is an array with 9 characters used as board for game
     * @param crossOrCircle - symbol counted on gameBoard
     * @return - number of crossOrCircle characters in boardGame
     */
    int checkingSumOfCrossesOrCircles(char[] boardGame, char crossOrCircle) {
        int numberOfCrossesOrCircles = 0;
        for (char elementOfBoard : boardGame) {
            if (elementOfBoard == crossOrCircle) numberOfCrossesOrCircles++;
        }
        return numberOfCrossesOrCircles;
    }

    /**
     * method responsible of adding CIRCLEs to gameBoard on medium or Hell level
     *
     * @param crossOrCircle - symbol needed to special responsible of method (Circle - blocking, CROSS - trying to end game)
     * @param gameBoard     - is an array with 9 characters used as board for game
     * @return - board with Computers turn
     */
    char[] computerOpponentAI(char crossOrCircle, char[] gameBoard) {
        Board board = new Board();
        Inserter inserter = new Inserter();
        Checker checker = new Checker(inserter, board);
        char a1 = gameBoard[0];
        char a2 = gameBoard[1];
        char a3 = gameBoard[2];
        char b1 = gameBoard[3];
        char b2 = gameBoard[4];
        char b3 = gameBoard[5];
        char c1 = gameBoard[6];
        char c2 = gameBoard[7];
        char c3 = gameBoard[8];
        if (checker.computerCheckMedium(a1, a2, crossOrCircle) && gameBoard[2] != CROSS && gameBoard[2] != CIRCLE) {
            gameBoard[2] = CIRCLE;
        } else if (checker.computerCheckMedium(a2, a3, crossOrCircle) && gameBoard[0] != CROSS && gameBoard[0] != CIRCLE) {
            gameBoard[0] = CIRCLE;
        } else if (checker.computerCheckMedium(a1, a3, crossOrCircle) && gameBoard[1] != CROSS && gameBoard[1] != CIRCLE) {
            gameBoard[1] = CIRCLE;
        } else if (checker.computerCheckMedium(b1, b2, crossOrCircle) && gameBoard[5] != CROSS && gameBoard[5] != CIRCLE) {
            gameBoard[5] = CIRCLE;
        } else if (checker.computerCheckMedium(b2, b3, crossOrCircle) && gameBoard[3] != CROSS && gameBoard[3] != CIRCLE) {
            gameBoard[3] = CIRCLE;
        } else if (checker.computerCheckMedium(b1, b3, crossOrCircle) && gameBoard[4] != CROSS && gameBoard[4] != CIRCLE) {
            gameBoard[4] = CIRCLE;
        } else if (checker.computerCheckMedium(c1, c2, crossOrCircle) && gameBoard[8] != CROSS && gameBoard[8] != CIRCLE) {
            gameBoard[8] = CIRCLE;
        } else if (checker.computerCheckMedium(c2, c3, crossOrCircle) && gameBoard[6] != CROSS && gameBoard[6] != CIRCLE) {
            gameBoard[6] = CIRCLE;
        } else if (checker.computerCheckMedium(c1, c3, crossOrCircle) && gameBoard[7] != CROSS && gameBoard[7] != CIRCLE) {
            gameBoard[7] = CIRCLE;
        } else if (checker.computerCheckMedium(a1, b1, crossOrCircle) && gameBoard[6] != CROSS && gameBoard[6] != CIRCLE) {
            gameBoard[6] = CIRCLE;
        } else if (checker.computerCheckMedium(c1, b1, crossOrCircle) && gameBoard[0] != CROSS && gameBoard[0] != CIRCLE) {
            gameBoard[0] = CIRCLE;
        } else if (checker.computerCheckMedium(c1, a1, crossOrCircle) && gameBoard[3] != CROSS && gameBoard[3] != CIRCLE) {
            gameBoard[3] = CIRCLE;
        } else if (checker.computerCheckMedium(a2, b2, crossOrCircle) && gameBoard[7] != CROSS && gameBoard[7] != CIRCLE) {
            gameBoard[7] = CIRCLE;
        } else if (checker.computerCheckMedium(a2, c2, crossOrCircle) && gameBoard[4] != CROSS && gameBoard[4] != CIRCLE) {
            gameBoard[4] = CIRCLE;
        } else if (checker.computerCheckMedium(b2, c2, crossOrCircle) && gameBoard[1] != CROSS && gameBoard[1] != CIRCLE) {
            gameBoard[1] = CIRCLE;
        } else if (checker.computerCheckMedium(a3, b3, crossOrCircle) && gameBoard[8] != CROSS && gameBoard[8] != CIRCLE) {
            gameBoard[8] = CIRCLE;
        } else if (checker.computerCheckMedium(a3, c3, crossOrCircle) && gameBoard[5] != CROSS && gameBoard[5] != CIRCLE) {
            gameBoard[5] = CIRCLE;
        } else if (checker.computerCheckMedium(b3, c3, crossOrCircle) && gameBoard[2] != CROSS && gameBoard[2] != CIRCLE) {
            gameBoard[2] = CIRCLE;
        } else if (checker.computerCheckMedium(a1, b2, crossOrCircle) && gameBoard[8] != CROSS && gameBoard[8] != CIRCLE) {
            gameBoard[8] = CIRCLE;
        } else if (checker.computerCheckMedium(c3, b2, crossOrCircle) && gameBoard[0] != CROSS && gameBoard[0] != CIRCLE) {
            gameBoard[0] = CIRCLE;
        } else if (checker.computerCheckMedium(c3, a1, crossOrCircle) && gameBoard[4] != CROSS && gameBoard[4] != CIRCLE) {
            gameBoard[4] = CIRCLE;
        } else if (checker.computerCheckMedium(a3, b2, crossOrCircle) && gameBoard[6] != CROSS && gameBoard[6] != CIRCLE) {
            gameBoard[6] = CIRCLE;
        } else if (checker.computerCheckMedium(c1, b2, crossOrCircle) && gameBoard[2] != CROSS && gameBoard[2] != CIRCLE) {
            gameBoard[2] = CIRCLE;
        } else if (checker.computerCheckMedium(c1, a3, crossOrCircle) && gameBoard[4] != CROSS && gameBoard[4] != CIRCLE) {
            gameBoard[4] = CIRCLE;
        }
        return gameBoard;
    }
}
