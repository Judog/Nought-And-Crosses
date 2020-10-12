package pl.kamilsieczkowski.utils.checkers;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.Insert;
import pl.kamilsieczkowski.utils.checkers.CheckerEasyLvl;

public class CheckerMediumLvl extends CheckerEasyLvl {


    public CheckerMediumLvl(Insert insert, Board board) {
        super(insert, board);
    }

    /**
     * all things done by computer player in one of winRequirementCheck method
     *
     * @param boardGame is an array with 9 characters used as board for game
     * @param insert    invocation of Insert class to use one of Insert method
     * @return is an array with 9 characters used as board for game, after changes done by computer player
     */
    @Override
    char[] insideLoopComputer(char[] boardGame, Insert insert) {
        boardGame = insert.computerOpponentInsertCirclesMediumLvl(boardGame);
        board.displayBoard(boardGame);
        return boardGame;
    }

    /**
     * @param one   - first char
     * @param two   - second char
     * @param three - third char
     * @return boolean condition one==two==three
     */
    boolean computerCheckMedium(char one, char two, char three) {
        return one == two && two == three;
    }
}
