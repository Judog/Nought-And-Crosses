package pl.kamilsieczkowski.utils.checkers;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.inserters.Inserter;

public class CheckerHellLvl extends CheckerMediumLvl {
    public CheckerHellLvl(Inserter inserter, Board board) {
        super(inserter, board);
    }

    /**
     * all things done by computer player in winRequirementCheckHell method
     *
     * @param boardGame is an array with 9 characters used as board for game
     * @param inserter    invocation of InserterHellLvl class to use one of Insert method
     * @return is array with 9 characters used as board for game, after changes done by computer player
     */

    char[] insideLoopComputer(char[] boardGame, Inserter inserter) {
        boardGame = inserter.computerOpponentInsertingCircleHellLvl(boardGame);
        board.displayBoard(boardGame);
        return boardGame;
    }
}
