package pl.kamilsieczkowski.game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class GameTest {
    private char[] firstRowX;
    private char[] secondRowX;
    private char[] thirdRowX;
    private char[] firstColumnX;
    private char[] secondColumnX;
    private char[] thirdColumnX;
    private char[] leftSlantX;
    private char[] rightSlantX;
    private char[] mockedBoard;
    private static Game mockedGame;
    private static Game game;


    @BeforeAll
    public static void steUp() {
        mockedGame = Mockito.mock(Game.class);
    }

    @BeforeEach
    public void start() {
        firstRowX = new char[]{'X', 'X', 'X', '4', '5', '6', '7', '8', '9'};
        secondRowX = new char[]{'1', '2', '3', 'X', 'X', 'X', '7', '8', '9'};
        thirdRowX = new char[]{'1', '2', '3', '4', '5', '6', 'X', 'X', 'X'};
        firstColumnX = new char[]{'X', '2', '3', 'X', '5', '6', 'X', '8', '9'};
        secondColumnX = new char[]{'1', 'X', '3', '4', 'X', '6', '7', 'X', '9'};
        thirdColumnX = new char[]{'1', '2', 'X', '4', '5', 'X', '7', '8', 'X'};
        rightSlantX = new char[]{'X', '2', '3', '4', 'X', '6', '7', '8', 'X'};
        leftSlantX = new char[]{'1', '2', 'X', '4', 'X', '6', 'X', '8', '9'};
        mockedBoard = new char[]{'1', '2', '3', '4', '5', '6', '7', '8'};
    }
    @Test
    public void shouldDisplayPlayGame(){
        mockedGame.playGameEasyLvl();
        Mockito.verify(mockedGame).playGameEasyLvl();
    }

}
