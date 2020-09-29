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

    public void winRequirementsCheck(char[] boardGame) {
        int turnCounter = 0;
        while (!winOrLoseGameCondition) {
            boardGame = insideLoopHuman(boardGame);
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
            if (turnCounter == 9) break;
            boardGame = insideLoopComputer(boardGame);
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
        }
        System.out.println("Game Over");
    }

    char[] insideLoopHuman(char[] boardGame) {
        boardGame = insert.insertCrosses(boardGame, 'X');
        board.displayBoard(boardGame);
        System.out.println("computer choose place, your turn:");
        return boardGame;
    }

    char[] insideLoopComputer(char[] boardGame) {
        boardGame = insert.computerOpponentInsertingCircles(boardGame);
        board.displayBoard(boardGame);
        return boardGame;
    }

    public void winRequirementsCheckMedium(char[] boardGame) {
        int turnCounter = 0;
        while (!winOrLoseGameCondition) {
            insideLoopHuman(boardGame);
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
            if (turnCounter == 9) break;
            insideLoopComputerMedium(boardGame);
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
        }
        System.out.println("Game Over");
    }

    char[] insideLoopComputerMedium(char[] boardGame) {
        boardGame = insert.computerOpponentInsertCirclesMediumLvl(boardGame);
        board.displayBoard(boardGame);
        return boardGame;
    }

    public void winRequirementsCheckHell(char[] boardGame) {
        int turnCounter = 0;
        while (!winOrLoseGameCondition) {
            insideLoopHuman(boardGame);
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
            if (turnCounter == 9) break;
            System.out.println("computer choose place, your turn:");
            insideLoopComputerHellLvl(boardGame);
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
        }
        System.out.println("Game Over");
    }

    char[] insideLoopComputerHellLvl(char[] boardGame) {
        boardGame = insert.computerOpponentInsertCirclesHellLvl(boardGame);
        board.displayBoard(boardGame);
        return boardGame;
    }

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

    void checkAWinner(int positionOneOfBoard, int positionTwoOfBoard, int positionThreeOfBoard, char[] boardGame) {
        if (boardGame[positionOneOfBoard] == 'X' && boardGame[positionTwoOfBoard] == 'X' && boardGame[positionThreeOfBoard] == 'X') {
            System.out.println("X wins!!!");
        } else {
            System.out.println("O wins!!!");
        }
    }

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

    boolean computerCheckMedium(char one, char two, char three) {
        return one == two && two == three;
    }
}