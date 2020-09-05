
import pl.kamilsieczkowski.gameBoard.GameBoard;
import pl.kamilsieczkowski.gamePlay.GamePlay;


public class NoughtAndCrossesApp {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        GamePlay gamePlay = new GamePlay(gameBoard.setBoard());
        gamePlay.playGame();
    }
}
