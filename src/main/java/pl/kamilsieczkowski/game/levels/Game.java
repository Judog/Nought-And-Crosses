package pl.kamilsieczkowski.game.levels;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.inserters.Inserter;
import pl.kamilsieczkowski.utils.checkers.Checker;

public class Game {
    protected char[] boardGame;
    protected Board board;
    protected Inserter inserter;

    public Game(char[] boardGame, Board board, Inserter inserter) {
        this.boardGame = boardGame;
        this.board = board;
        this.inserter = inserter;
    }

    /**
     * Starts game on easy lvl from Menu
     */
    public void playGame(String level) {
        Checker checker = new Checker(inserter, board);
        board.displayBoard(boardGame);
        checker.winRequirementsCheck(level, boardGame);
    }
}
