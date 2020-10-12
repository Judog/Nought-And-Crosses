package pl.kamilsieczkowski.game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.kamilsieczkowski.utils.Checker;


public class GameTest {
    private static Checker mockedChecker;
    private static Board mockedBoard;
    private static char[] startBoard;
    private static Game mockedGame;

    @BeforeAll
    public static void steUp() {
        mockedChecker = Mockito.mock(Checker.class);
        mockedBoard = Mockito.mock(Board.class);
        startBoard = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        mockedGame = Mockito.mock(Game.class);
    }

    @Test
    public void givenPlayGameEasyLvlWhenInvokedShouldReturnTrue() {
        mockedGame.playGameEasyLvl();
        Mockito.verify(mockedGame).playGameEasyLvl();
    }
    @Test
    public void givenPlayGameMediumLvlWhenInvokedShouldReturnTrue() {
        mockedGame.playGameOnMediumLvl();
        Mockito.verify(mockedGame).playGameOnMediumLvl();
    }
    @Test
    public void givenPlayGameHellLvlWhenInvokedShouldReturnTrue() {
        mockedGame.playGameOnHellLvl();
        Mockito.verify(mockedGame).playGameOnHellLvl();
    }
    @Test
    public void givenPlayGameWithOtherPlayerWhenInvokedShouldReturnTrue() {
        mockedGame.playGameWithOtherPlayer();
        Mockito.verify(mockedGame).playGameWithOtherPlayer();
    }
}
