package pl.kamilsieczkowski.utils.checkers;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.inserters.Inserter;

import static pl.kamilsieczkowski.constants.Constants.CIRCLE;
import static pl.kamilsieczkowski.constants.Constants.CROSS;
import static pl.kamilsieczkowski.constants.Texts.*;

public class CheckerTwoPlayers extends Checker {
    public CheckerTwoPlayers(Inserter inserter, Board board) {
        super(inserter, board);
    }

    /**
     * checking that first or second player wins game.
     * implements methods of Insert class, that methods inserting circles and crosses
     * break is for statement when nobody wins.
     *
     * @param boardGame - is an array with 9 characters used as board for game
     */
    public void winRequirementsCheck(char[] boardGame) {
        int turnCounter = 0;
        while (!winOrLoseGameCondition) {
            insideLoopHuman(boardGame, inserter, CROSS);
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
            if (turnCounter == 9) {
                break;
            }
            insideLoopHuman(boardGame, inserter, CIRCLE);
            winOrLoseGameCondition = multipleConditionsCheck(boardGame);
            turnCounter++;
        }
        System.out.println(GAME_OVER);
    }

    /**
     * all things done by human player in one of winRequirementCheck methods
     *
     * @param boardGame - is an array with 9 characters used as board for game
     * @param inserter  -  invocation of Insert class to use one of Insert method
     * @return - is an array with 9 characters used as board for game, after changes done by player
     */
    char[] insideLoopHuman(char[] boardGame, Inserter inserter, char crossOrCircle) {
        boardGame = inserter.insertCrosses(boardGame, crossOrCircle);
        board.displayBoard(boardGame);
        secondPlayerTurnMessage(crossOrCircle);
        return boardGame;
    }

    /**
     * message after first turn of game
     *
     * @param crossOrCircle - symbol of player CROSS or CIRCLE
     */
    void secondPlayerTurnMessage(char crossOrCircle) {
        System.out.println(PLAYER + SPACE + crossOrCircle + SPACE + TURN_IS_DONE);
        char secondPlayer = CROSS;
        if (crossOrCircle == CROSS) {
            secondPlayer = CIRCLE;
        } else {
            secondPlayer = CROSS;
        }
        System.out.println(IT_IS + SPACE + secondPlayer + SPACE + PLAYER_TURN);
    }
}
