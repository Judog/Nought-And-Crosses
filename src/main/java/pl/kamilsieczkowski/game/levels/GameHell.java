package pl.kamilsieczkowski.game.levels;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.game.levels.GameMedium;
import pl.kamilsieczkowski.utils.Insert;
import pl.kamilsieczkowski.utils.checkers.CheckerHellLvl;


public class GameHell extends GameMedium {
    public GameHell(char[] boardGame) {
        super(boardGame);
    }

    /**
     * Starts game on medium lvl from Menu
     */
    @Override
    public void playGame() {
        Board board = new Board();
        Insert insert = new Insert();
        CheckerHellLvl checker = new CheckerHellLvl(insert, board);
        board.displayBoard(boardGame);
        checker.winRequirementsCheck(boardGame);
    }
}
