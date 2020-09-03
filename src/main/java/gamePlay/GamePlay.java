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
        while (!winOrLoseGameCondition) {
            boardGame = inserter.insertCrosses(boardGame);
            boardGame = inserter.computerOpponentInsertingCircles(boardGame);
            winOrLoseGameCondition = multipleConditionsCheck();
        }
        System.out.println("Game Over");
    }

    boolean conditionsCheck(int positionOneOfBoard, int positionTwoOfBoard, int positionThreeOfBoard) {
        boolean conditionChecker;
        if (boardGame[positionOneOfBoard] == boardGame[positionTwoOfBoard] && boardGame[positionTwoOfBoard] == boardGame[positionThreeOfBoard]) {
            conditionChecker = true;
        } else {
            conditionChecker = false;
        }
        return conditionChecker;
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
