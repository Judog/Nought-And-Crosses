package pl.kamilsieczkowski.game.levels;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.Inserter;
import pl.kamilsieczkowski.utils.checkers.CheckerEasyLvl;

public class GameEasy {
    protected char[] boardGame;
    protected Board board;
    protected Inserter inserter;

    public GameEasy(char[] boardGame, Board board, Inserter inserter) {
        this.boardGame = boardGame;
        this.board = board;
        this.inserter = inserter;
    }

    /**
     * Starts game on easy lvl from Menu
     */
    public void playGame() {
        CheckerEasyLvl checker = new CheckerEasyLvl(inserter, board);
        board.displayBoard(boardGame);
        checker.winRequirementsCheck(boardGame);
    }
}
