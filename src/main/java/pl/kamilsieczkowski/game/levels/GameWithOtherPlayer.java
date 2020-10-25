package pl.kamilsieczkowski.game.levels;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.inserters.Inserter;
import pl.kamilsieczkowski.utils.checkers.CheckerTwoPlayers;


public class GameWithOtherPlayer extends Game {


    public GameWithOtherPlayer(char[] boardGame, Board board, Inserter inserter) {
        super(boardGame, board, inserter);
    }

    /**
     * Starts game with other player from Menu
     */
    @Override
    public void playGame(String levels) {
        CheckerTwoPlayers checkerTwoPlayers = new CheckerTwoPlayers(inserter, board);
        board.displayBoard(boardGame);
        checkerTwoPlayers.winRequirementsCheck(levels, boardGame);
    }
}
