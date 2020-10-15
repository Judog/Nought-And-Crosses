package pl.kamilsieczkowski.game.levels;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.inserters.Inserter;
import pl.kamilsieczkowski.utils.checkers.CheckerHellLvl;


public class GameHell extends GameMedium {
    public GameHell(char[] boardGame, Board board, Inserter inserter) {
        super(boardGame, board, inserter);
    }

    /**
     * Starts game on Hell lvl from Menu
     */
    @Override
    public void playGame() {
        CheckerHellLvl checker = new CheckerHellLvl(inserter, board);
        board.displayBoard(boardGame);
        checker.winRequirementsCheck(boardGame);
    }
}
