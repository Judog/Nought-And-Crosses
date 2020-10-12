package pl.kamilsieczkowski.utils.checkers;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.Insert;

public class CheckerTwoPlayers extends CheckerEasyLvl {
    public CheckerTwoPlayers(Insert insert, Board board) {
        super(insert, board);
    }

    /**
     * checking that first or second player wins game.
     * implements methods of Insert class, that methods inserting circles and crosses
     * break is for statement when nobody wins.
     *
     * @param boardGame - is an array with 9 characters used as board for game
     */
    @Override
    public void winRequirementsCheck(char[] boardGame) {
        int turnCounter = 0;
        while (!winOrLoseGameCondition) {
            insideLoopHuman(boardGame, insert, 'X');
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
            if (turnCounter == 9) {
                break;
            }
            insideLoopHuman(boardGame, insert, 'O');
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
        }
        System.out.println("Game Over");
    }

    char[] insideLoopHuman(char[] boardGame, Insert insert, char crossOrCircle) {
        boardGame = insert.insertCrosses(boardGame, crossOrCircle);
        board.displayBoard(boardGame);
        secondPlayerTurnMessage(crossOrCircle);
        return boardGame;
    }

    void secondPlayerTurnMessage(char crossOrCircle) {
        System.out.println("player " + crossOrCircle + " turn is done");
        char secondPlayer = 'X';
        if (crossOrCircle == 'X') {
            secondPlayer = 'O';
        } else {
            secondPlayer = 'X';
        }
        System.out.println("It's " + secondPlayer + " player turn");
    }
}
