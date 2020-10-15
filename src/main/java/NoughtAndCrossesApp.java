import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.game.Menu;
import pl.kamilsieczkowski.utils.inserters.Inserter;

public class NoughtAndCrossesApp {
    public static void main(String[] args) {
        Board board = new Board();
        Inserter inserter = new Inserter();
        Menu menu = new Menu(board, inserter);
        menu.displayMenu();
    }
}
