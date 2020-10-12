package pl.kamilsieczkowski.utils.checkers;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.Insert;

public class CheckerEasyLvl {
    protected boolean winOrLoseGameCondition;
    protected Insert insert;
    protected Board board;

    public CheckerEasyLvl(Insert insert, Board board) {
        this.insert = new Insert();
        this.board = new Board();
    }

    /**
     * checking that player or computer wins game on easy lvl.
     * implements methods of human and computer, that methods inserting circles and crosses
     * break is for statement when nobody wins.
     *
     * @param boardGame - is an array with 9 characters used as board for game
     */
    public void winRequirementsCheck(char[] boardGame) {
        int turnCounter = 0;
        while (!winOrLoseGameCondition) {
            boardGame = insideLoopHuman(boardGame, insert);
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
            if (turnCounter == 9) break;
            boardGame = insideLoopComputer(boardGame, insert);
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
        }
        System.out.println("Game Over");
    }

    /**
     * all things done by human player in one of winRequirementCheck methods
     *
     * @param boardGame is an array with 9 characters used as board for game
     * @param insert    invocation of Insert class to use one of Insert method
     * @return is an array with 9 characters used as board for game, after changes done by player
     */
    char[] insideLoopHuman(char[] boardGame, Insert insert) {
        boardGame = insert.insertCrosses(boardGame, 'X');
        board.displayBoard(boardGame);
        System.out.println("computer choose place, your turn:");
        return boardGame;
    }

    /**
     * all things done by computer player in one of winRequirementCheck method
     *
     * @param boardGame is an array with 9 characters used as board for game
     * @param insert    invocation of Insert class to use one of Insert method
     * @return is an array with 9 characters used as board for game, after changes done by computer player
     */
    char[] insideLoopComputer(char[] boardGame, Insert insert) {
        boardGame = insert.computerOpponentInsertingCircles(boardGame);
        board.displayBoard(boardGame);
        return boardGame;
    }

    /**
     * @param positionOneOfBoard   - first of three positions of board
     * @param positionTwoOfBoard   - second of three positions of board
     * @param positionThreeOfBoard - third of three positions of board
     * @param boardGame            - is an array with 9 characters used as board for game
     * @return - boolean condition for multipleConditionsCheck method
     */
    boolean conditionsCheck(int positionOneOfBoard, int positionTwoOfBoard, int positionThreeOfBoard, char[] boardGame) {
        boolean conditionChecker;
        if (boardGame[positionOneOfBoard] == boardGame[positionTwoOfBoard] && boardGame[positionTwoOfBoard] == boardGame[positionThreeOfBoard]) {
            conditionChecker = true;
            checkAWinner(positionOneOfBoard, positionTwoOfBoard, positionThreeOfBoard, boardGame);
        } else {
            conditionChecker = false;
        }
        return conditionChecker;
    }

    /**
     * method prints comments of X or O player win.
     *
     * @param positionOneOfBoard   - first of three positions of board
     * @param positionTwoOfBoard   - second of three positions of board
     * @param positionThreeOfBoard - third of three positions of board
     * @param boardGame            - is an array with 9 characters used as board for game
     */
    void checkAWinner(int positionOneOfBoard, int positionTwoOfBoard, int positionThreeOfBoard, char[] boardGame) {
        if (boardGame[positionOneOfBoard] == 'X' && boardGame[positionTwoOfBoard] == 'X' && boardGame[positionThreeOfBoard] == 'X') {
            System.out.println("X wins!!!");
        } else {
            System.out.println("O wins!!!");
        }
    }

    /**
     * method checking all possible conditions to win a game.
     *
     * @param boardGame - is an array with 9 characters used as board for game
     * @return - return true when one of possible conditions is a true.
     */
    boolean multipleConditionsCheck(char[] boardGame) {
        boolean firstRow = (conditionsCheck(0, 1, 2, boardGame));
        boolean secondRow = (conditionsCheck(3, 4, 5, boardGame));
        boolean thirdRow = (conditionsCheck(6, 7, 8, boardGame));
        boolean firstColumn = (conditionsCheck(0, 3, 6, boardGame));
        boolean secondColumn = (conditionsCheck(1, 4, 7, boardGame));
        boolean thirdColumn = (conditionsCheck(2, 5, 8, boardGame));
        boolean rightSlant = (conditionsCheck(0, 4, 8, boardGame));
        boolean leftSlant = (conditionsCheck(2, 4, 6, boardGame));
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
