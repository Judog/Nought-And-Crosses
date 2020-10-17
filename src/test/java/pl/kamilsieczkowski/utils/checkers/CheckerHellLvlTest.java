package pl.kamilsieczkowski.utils.checkers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.inserters.Inserter;

public class CheckerHellLvlTest {
    private static CheckerHellLvl checkerHellLvll;
    private static Inserter mockedInserter;
    private static Board mockedBoard;
    private static char[] gameBoard;
    private char[] winBoard;
    private char[] xBoard;

    @BeforeAll
    public static void setUp() {
        mockedInserter = Mockito.mock(Inserter.class);
        mockedBoard = Mockito.mock(Board.class);
        checkerHellLvll = new CheckerHellLvl(mockedInserter, mockedBoard);
        gameBoard = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    @BeforeEach
    public void invoke() {
        xBoard = new char[]{'X', '2', '3', '4', '5', '6', '7', '8', '9'};
        winBoard = new char[]{'X', 'X', 'X', '4', '5', '6', '7', '8', '9'};
    }

    @Test
    public void givenCrossToAddWhenInsideLoopComputerIsInvokedThenCrossIsAdded() {
        Mockito.when(mockedInserter.computerOpponentInsertingCircleHellLvl(gameBoard)).thenReturn(xBoard);
        char[] test = checkerHellLvll.insideLoopComputer(gameBoard, mockedInserter);
        Assertions.assertArrayEquals(test, xBoard);
    }
}
