package pl.kamilsieczkowski.utils;

import pl.kamilsieczkowski.game.Board;

public class Check {
    boolean winOrLoseGameCondition;
    private Insert insert;
    private Board board;

    public Check() {
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
    public void winRequirementsCheckEasyLvl(char[] boardGame) {
        int turnCounter = 0;
        while (!winOrLoseGameCondition) {
            boardGame = insideLoopHuman(boardGame, insert);
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
            if (turnCounter == 9) break;
            boardGame = insideLoopComputerEasyMode(boardGame, insert);
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
    char[] insideLoopComputerEasyMode(char[] boardGame, Insert insert) {
        boardGame = insert.computerOpponentInsertingCircles(boardGame);
        board.displayBoard(boardGame);
        return boardGame;
    }

    /**
     * checking that player or computer wins game on medium lvl.
     * implements methods of human and computer, that methods inserting circles and crosses
     * break is for statement when nobody wins.
     *
     * @param boardGame - is an array with 9 characters used as board for game
     */
    public void winRequirementsCheckMedium(char[] boardGame) {
        int turnCounter = 0;
        while (!winOrLoseGameCondition) {
            insideLoopHuman(boardGame, insert);
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
            if (turnCounter == 9) break;
            insideLoopComputerMedium(boardGame, insert);
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
        }
        System.out.println("Game Over");
    }

    /**
     * all things done by computer player in one of winRequirementCheck method
     *
     * @param boardGame is an array with 9 characters used as board for game
     * @param insert    invocation of Insert class to use one of Insert method
     * @return is an array with 9 characters used as board for game, after changes done by computer player
     */
    char[] insideLoopComputerMedium(char[] boardGame, Insert insert) {
        boardGame = insert.computerOpponentInsertCirclesMediumLvl(boardGame);
        board.displayBoard(boardGame);
        return boardGame;
    }

    /**
     * checking that player or computer wins game on hell lvl.
     * implements methods of human and computer, that methods inserting circles and crosses
     * break is for statement when nobody wins.
     *
     * @param boardGame - is an array with 9 characters used as board for game
     */
    public void winRequirementsCheckHell(char[] boardGame) {
        int turnCounter = 0;
        while (!winOrLoseGameCondition) {
            insideLoopHuman(boardGame, new Insert());
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
            if (turnCounter == 9) break;
            System.out.println("computer choose place, your turn:");
            insideLoopComputerHellLvl(boardGame, insert);
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
        }
        System.out.println("Game Over");
    }
    /**
     * all things done by computer player in winRequirementCheckHell method
     *
     * @param boardGame is an array with 9 characters used as board for game
     * @param insert    invocation of Insert class to use one of Insert method
     * @return is array with 9 characters used as board for game, after changes done by computer player
     */
    char[] insideLoopComputerHellLvl(char[] boardGame, Insert insert) {
        boardGame = insert.computerOpponentInsertCirclesHellLvl(boardGame);
        board.displayBoard(boardGame);
        return boardGame;
    }
    /**
     * checking that first or second player wins game.
     * implements methods of Insert class, that methods inserting circles and crosses
     * break is for statement when nobody wins.
     *
     * @param boardGame - is an array with 9 characters used as board for game
     */
    public void winRequirementsCheckTwoPlayers(char[] boardGame) {
        int turnCounter = 0;
        while (!winOrLoseGameCondition) {
            boardGame = insert.insertCrosses(boardGame, 'X');
            board.displayBoard(boardGame);
            System.out.println("First player (X) choose place, your turn Second (O) player:");
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
            if (turnCounter == 9) break;
            boardGame = insert.insertCrosses(boardGame, 'O');
            board.displayBoard(boardGame);
            System.out.println("Second player (O) choose place, your turn First (X) player:");
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
        }
        System.out.println("Game Over");
    }

    /**
     *
     * @param positionOneOfBoard - first of three positions of board
     * @param positionTwoOfBoard - second of three positions of board
     * @param positionThreeOfBoard - third of three positions of board
     * @param boardGame - is an array with 9 characters used as board for game
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
     * @param positionOneOfBoard - first of three positions of board
     * @param positionTwoOfBoard - second of three positions of board
     * @param positionThreeOfBoard - third of three positions of board
     * @param boardGame - is an array with 9 characters used as board for game
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

    /**
     *
     * @param one - first char
     * @param two - second char
     * @param three - third char
     * @return boolean condition one==two==three
     */
    boolean computerCheckMedium(char one, char two, char three) {
        return one == two && two == three;
    }
}