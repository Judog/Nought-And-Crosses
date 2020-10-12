package pl.kamilsieczkowski.game.levels;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.game.levels.GameEasy;
import pl.kamilsieczkowski.utils.Insert;
import pl.kamilsieczkowski.utils.checkers.CheckerMediumLvl;

public class GameMedium extends GameEasy {



    public GameMedium(char[] boardGame) {
        super(boardGame);
    }
    /**
     * Starts game on medium lvl from Menu
     */
    public void playGame() {
        Board board = new Board();
        Insert insert = new Insert();
        CheckerMediumLvl checker = new CheckerMediumLvl(insert, board);
        board.displayBoard(boardGame);
        checker.winRequirementsCheck(boardGame);
    }
}
