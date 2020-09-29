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

    public void playGameEasyLvl() {
        board.displayBoard(boardGame);
        check.winRequirementsCheck(boardGame);
    }

    public void playGameOnMediumLvl() {
        board.displayBoard(boardGame);
        check.winRequirementsCheckMedium(boardGame);
    }

    public void playGameOnHellLvl() {
        board.displayBoard(boardGame);
        check.winRequirementsCheckHell(boardGame);
    }

    public void playGameWithOtherPlayer() {
        board.displayBoard(boardGame);
        check.winRequirementsCheckTwoPlayers(boardGame);
    }
}
