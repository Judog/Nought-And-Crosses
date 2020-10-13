package pl.kamilsieczkowski.utils.checkers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.Inserter;

public class CheckerMediumLvlTest {
    private static CheckerMediumLvl checkerMediumLvl;
    private static Inserter mockedInserter;
    private static Board mockedBoard;
    private static char[] gameBoard;
    private char[] winBoard;
    private char[] xBoard;

    @BeforeAll
    public static void setUp() {
        mockedInserter = Mockito.mock(Inserter.class);
        mockedBoard = Mockito.mock(Board.class);
        checkerMediumLvl = new CheckerMediumLvl(mockedInserter, mockedBoard);
        gameBoard = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    @BeforeEach
    public void invoke() {
        xBoard = new char[]{'X', '2', '3', '4', '5', '6', '7', '8', '9'};
        winBoard = new char[]{'X', 'X', 'X', '4', '5', '6', '7', '8', '9'};
    }
    @Test
    public void givenCrossToAddWhenInsideLoopComputerIsInvokedThenCrossIsAdded() {
        Mockito.when(mockedInserter.computerOpponentInsertCirclesMediumLvl(gameBoard)).thenReturn(xBoard);
        char[] test = checkerMediumLvl.insideLoopComputer(gameBoard, mockedInserter);
        Assertions.assertArrayEquals(test, xBoard);
    }
    @Test
    public void givenThreeXWhenComputerCheckMediumIsInvokedThenReturnTrue() {
      boolean computerCheckMediumTrue = checkerMediumLvl.computerCheckMedium('X','X','X');
        Assertions.assertTrue(computerCheckMediumTrue);
    }
    @Test
    public void givenThreeDifferentCharsWhenComputerCheckMediumIsInvokedThenReturnTrue() {
        boolean computerCheckMediumFalse = checkerMediumLvl.computerCheckMedium('X','O','X');
        Assertions.assertFalse(computerCheckMediumFalse);
    }
}
