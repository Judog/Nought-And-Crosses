package pl.kamilsieczkowski.game.levels;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.Inserter;
import pl.kamilsieczkowski.utils.checkers.CheckerMediumLvl;

public class GameMedium extends GameEasy {


    public GameMedium(char[] boardGame, Board board, Inserter inserter) {
        super(boardGame, board, inserter);
    }

    /**
     * Starts game on medium lvl from Menu
     */
    public void playGame() {
        CheckerMediumLvl checker = new CheckerMediumLvl(inserter, board);
        board.displayBoard(boardGame);
        checker.winRequirementsCheck(boardGame);
    }
}
