package pl.kamilsieczkowski.game.levels;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.Checker;
import pl.kamilsieczkowski.utils.Insert;
import pl.kamilsieczkowski.utils.checkers.CheckerEasyLvl;

public class GameEasy {
    private CheckerEasyLvl checker;
    private Board board;
    protected char[] boardGame;


    public GameEasy(char[] boardGame) {
        this.boardGame = boardGame;
    }

    /**
     * Starts game on easy lvl from Menu
     */
    public void playGame() {
        Board board = new Board();
        Insert insert = new Insert();
        CheckerEasyLvl checker = new CheckerEasyLvl(insert, board);
        board.displayBoard(boardGame);
        checker.winRequirementsCheck(boardGame);
    }
}
