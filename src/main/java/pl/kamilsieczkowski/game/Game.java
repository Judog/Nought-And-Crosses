package pl.kamilsieczkowski.game;

import pl.kamilsieczkowski.utils.Check;

public class Game {
    private Check check;
    private Board board;
    private char[] boardGame;


    public Game(Check check, Board board, char[] boardGame) {
        this.check = check;
        this.board = board;
        this.boardGame = boardGame;
    }

    /**
     * Starts game on easy lvl from Menu
     */
    public void playGameEasyLvl() {
        board.displayBoard(boardGame);
        check.winRequirementsCheckEasyLvl(boardGame);
    }

    /**
     * Starts game on medium lvl from Menu
     */
    public void playGameOnMediumLvl() {
        board.displayBoard(boardGame);
        check.winRequirementsCheckMedium(boardGame);
    }

    /**
     * Starts game on Hell lvl from Menu
     */
    public void playGameOnHellLvl() {
        board.displayBoard(boardGame);
        check.winRequirementsCheckHell(boardGame);
    }

    /**
     * Starts game with 2 players from Menu
     */
    public void playGameWithOtherPlayer() {
        board.displayBoard(boardGame);
        check.winRequirementsCheckTwoPlayers(boardGame);
    }
}
