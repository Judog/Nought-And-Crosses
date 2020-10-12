package pl.kamilsieczkowski.utils.checkers;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.Insert;

public class CheckerHellLvl extends CheckerMediumLvl {
    public CheckerHellLvl(Insert insert, Board board) {
        super(insert, board);
    }

    /**
     * all things done by computer player in winRequirementCheckHell method
     *
     * @param boardGame is an array with 9 characters used as board for game
     * @param insert    invocation of Insert class to use one of Insert method
     * @return is array with 9 characters used as board for game, after changes done by computer player
     */
    @Override
    char[] insideLoopComputer(char[] boardGame, Insert insert) {
        boardGame = insert.computerOpponentInsertCirclesHellLvl(boardGame);
        board.displayBoard(boardGame);
        return boardGame;
    }
}
