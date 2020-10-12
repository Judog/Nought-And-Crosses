package pl.kamilsieczkowski.game;

import pl.kamilsieczkowski.utils.Checker;

public class Game {
    private Checker checker;
    private Board board;
    private char[] boardGame;


    public Game(Checker checker, Board board, char[] boardGame) {
        this.checker = checker;
        this.board = board;
        this.boardGame = boardGame;
    }

    /**
     * Starts game on easy lvl from Menu
     */
    public void playGameEasyLvl() {
        board.displayBoard(boardGame);
        checker.winRequirementsCheckEasyLvl(boardGame);
    }

    /**
     * Starts game on medium lvl from Menu
     */
    public void playGameOnMediumLvl() {
        board.displayBoard(boardGame);
        checker.winRequirementsCheckMedium(boardGame);
    }

    /**
     * Starts game on Hell lvl from Menu
     */
    public void playGameOnHellLvl() {
        board.displayBoard(boardGame);
        checker.winRequirementsCheckHell(boardGame);
    }

    /**
     * Starts game with 2 players from Menu
     */
    public void playGameWithOtherPlayer() {
        board.displayBoard(boardGame);
        checker.winRequirementsCheckTwoPlayers(boardGame);
    }
}
