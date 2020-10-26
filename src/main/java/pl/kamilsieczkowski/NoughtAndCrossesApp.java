package pl.kamilsieczkowski;

import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.game.Menu;
import pl.kamilsieczkowski.game.levels.GameWithOtherPlayer;
import pl.kamilsieczkowski.utils.inserters.Inserter;

public class NoughtAndCrossesApp {
    public static void main(String[] args) {
        Board board = new Board();
        Inserter inserter = new Inserter();
        GameWithOtherPlayer gameWithOtherPlayer = new GameWithOtherPlayer(board.setStartBoard(), board, inserter);
        Menu menu = new Menu(board, inserter);
        menu.displayMenu(gameWithOtherPlayer);
    }
}
