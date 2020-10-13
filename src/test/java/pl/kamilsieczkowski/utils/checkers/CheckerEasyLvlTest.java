package pl.kamilsieczkowski.utils.checkers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.Inserter;

import static pl.kamilsieczkowski.constants.Constants.CROSS;

public class CheckerEasyLvlTest {
    private static CheckerEasyLvl checkerEasyLvl;
    private static CheckerEasyLvl mockedCheckerEasyLvl;
    private static Inserter mockedInserter;
    private static Board mockedBoard;
    private static char[] gameBoard;
    private char[] winBoard;
    private char[] xBoard;

    @BeforeAll
    public static void setUp() {
        mockedInserter = Mockito.mock(Inserter.class);
        mockedBoard = Mockito.mock(Board.class);
        checkerEasyLvl = new CheckerEasyLvl(mockedInserter, mockedBoard);
        mockedCheckerEasyLvl = Mockito.mock(CheckerEasyLvl.class);
        gameBoard = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    @BeforeEach
    public void invoke() {
        xBoard = new char[]{'X', '2', '3', '4', '5', '6', '7', '8', '9'};
        winBoard = new char[]{'X', 'X', 'X', '4', '5', '6', '7', '8', '9'};
    }

    @Test
    public void givenCrossToAddwhenInsideLoopHumanIsInvokedThenCrossIsAdded() {
        Mockito.when(mockedInserter.insertCrosses(gameBoard, CROSS)).thenReturn(xBoard);
        char[] test = checkerEasyLvl.insideLoopHuman(gameBoard, mockedInserter);
        Assertions.assertArrayEquals(test, xBoard);
    }

    @Test
    public void givenCrossToAddwhenInsideLoopComputerIsInvokedThenCrossIsAdded() {
        Mockito.when(mockedInserter.computerOpponentInsertingCircles(gameBoard)).thenReturn(xBoard);
        char[] test = checkerEasyLvl.insideLoopComputer(gameBoard, mockedInserter);
        Assertions.assertArrayEquals(test, xBoard);
    }

    @Test
    public void givenThreePositionAndNotWinningBoardWhenConditionsCheckIsInvokedThenReturnFalse() {
        boolean win = checkerEasyLvl.conditionsCheck(1, 2, 3, gameBoard);
        Assertions.assertFalse(win);
    }


    @Test
    public void givenBoardWhenMultipleConditionsCheckIsInvokedThenReturnFalse() {
        boolean notWin = checkerEasyLvl.multipleConditionsCheck(gameBoard);
        Assertions.assertFalse(notWin);
    }
}
