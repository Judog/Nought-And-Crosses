package gamePlay;

import gameBoard.GameBoard;
import gamePlay.inserters.Inserter;

public class GamePlay {
    private char[] boardGame;
    boolean winOrLoseGameCondition;

    public GamePlay(char[] boardGame) {
        this.boardGame = boardGame;
    }

    public void playGame() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.displayBoard(boardGame);
        winRequirementsCheck();
    }

    public void winRequirementsCheck() {
        Inserter inserter = new Inserter();
        int turnCounter = 0;
        while (!winOrLoseGameCondition) {
            boardGame = inserter.insertCrosses(boardGame);
            winOrLoseGameCondition = multipleConditionsCheck();
            turnCounter++;
            if (turnCounter == 9) break;
            boardGame = inserter.computerOpponentInsertingCircles(boardGame);
            winOrLoseGameCondition = multipleConditionsCheck();
            turnCounter++;
        }
        System.out.println("Game Over");
    }


    boolean conditionsCheck(int positionOneOfBoard, int positionTwoOfBoard, int positionThreeOfBoard) {
        boolean conditionChecker;
        if (boardGame[positionOneOfBoard] == boardGame[positionTwoOfBoard] && boardGame[positionTwoOfBoard] == boardGame[positionThreeOfBoard]) {
            conditionChecker = true;
            checkAWinner(positionOneOfBoard, positionTwoOfBoard, positionThreeOfBoard);
        } else {
            conditionChecker = false;
        }
        return conditionChecker;
    }

    void checkAWinner(int positionOneOfBoard, int positionTwoOfBoard, int positionThreeOfBoard) {
        if (boardGame[positionOneOfBoard] == 'X' && boardGame[positionTwoOfBoard] == 'X' && boardGame[positionThreeOfBoard] == 'X') {
            System.out.println("You win");
        } else {
            System.out.println("You Lose");
        }
    }

    boolean multipleConditionsCheck() {
        boolean firstRow = (conditionsCheck(0, 1, 2));
        boolean secondRow = (conditionsCheck(3, 4, 5));
        boolean thirdRow = (conditionsCheck(6, 7, 8));
        boolean firstColumn = (conditionsCheck(0, 3, 6));
        boolean secondColumn = (conditionsCheck(1, 4, 7));
        boolean thirdColumn = (conditionsCheck(2, 5, 8));
        boolean rightSlant = (conditionsCheck(0, 4, 8));
        boolean leftSlant = (conditionsCheck(2, 4, 6));
        boolean[] multipleConditions = new boolean[]{
                firstRow, secondRow, thirdRow, firstColumn, secondColumn, thirdColumn, rightSlant, leftSlant
        };
        boolean multipleConditionChecker = false;
        for (int counter = 0; counter <= 7; counter++) {
            if (multipleConditions[counter] == true) {
                multipleConditionChecker = true;
            }
        }
        return multipleConditionChecker;
    }

}
