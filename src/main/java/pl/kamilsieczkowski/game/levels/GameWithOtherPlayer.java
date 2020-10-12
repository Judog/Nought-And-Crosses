package pl.kamilsieczkowski.game.levels;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.Insert;
import pl.kamilsieczkowski.utils.checkers.CheckerTwoPlayers;


public class GameWithOtherPlayer extends GameEasy {

    public GameWithOtherPlayer(char[] boardGame) {
        super(boardGame);
    }
    @Override
    public void playGame() {
        Board board = new Board();
        Insert insert = new Insert();
        CheckerTwoPlayers checkerTwoPlayers = new CheckerTwoPlayers(insert, board);
        board.displayBoard(boardGame);
        checkerTwoPlayers.winRequirementsCheck(boardGame);
    }
}
