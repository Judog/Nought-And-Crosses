package pl.kamilsieczkowski.utils.checkers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.inserters.Inserter;

import static pl.kamilsieczkowski.constants.Constants.*;

public class CheckerTest {
    private static Checker checker;
    private static Checker mockedChecker;
    private static Inserter mockedInserter;
    private static Board mockedBoard;
    private static char[] gameBoard;
    private char[] winBoard;
    private char[] xBoard;

    @BeforeAll
    public static void setUp() {
        mockedInserter = Mockito.mock(Inserter.class);
        mockedBoard = Mockito.mock(Board.class);
        checker = new Checker(mockedInserter, mockedBoard);
        mockedChecker = Mockito.mock(Checker.class);
        gameBoard = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    @BeforeEach
    public void invoke() {
        xBoard = new char[]{'X', '2', '3', '4', '5', '6', '7', '8', '9'};
        winBoard = new char[]{'X', 'X', 'X', '4', '5', '6', '7', '8', '9'};
    }

    @Test
    public void givenCrossToAddWhenInsideLoopHumanIsInvokedThenCrossIsAdded() {
        Mockito.when(mockedInserter.insertCrosses(gameBoard, CROSS)).thenReturn(xBoard);
        char[] test = checker.humanTurn(gameBoard, mockedInserter);
        Assertions.assertArrayEquals(test, xBoard);
    }

    @Test
    public void givenCrossToAddOnEasyLvlWhenInsideLoopComputerIsInvokedThenCrossIsAdded() {
        Mockito.when(mockedInserter.computerOpponentInsertingCircles(gameBoard)).thenReturn(xBoard);
        char[] test = checker.computerTurn(EASY, gameBoard, mockedInserter);
        Assertions.assertArrayEquals(test, xBoard);
    }

    @Test
    public void givenThreePositionAndNotWinningBoardWhenConditionsCheckIsInvokedThenReturnFalse() {
        boolean win = checker.conditionsCheck(1, 2, 3, gameBoard);
        Assertions.assertFalse(win);
    }

    @Test
    public void givenBoardWhenMultipleConditionsCheckIsInvokedThenReturnFalse() {
        boolean notWin = checker.multipleConditionsCheck(gameBoard);
        Assertions.assertFalse(notWin);
    }

    @Test
    public void givenCrossToAddWhenInsideLoopComputerIsInvokedThenCrossIsAdded() {
        Mockito.when(mockedInserter.computerOpponentInsertingCircleMediumLvl(gameBoard)).thenReturn(xBoard);
        char[] test = checker.computerTurn(MEDIUM, gameBoard, mockedInserter);
        Assertions.assertArrayEquals(test, xBoard);
    }

    @Test
    public void givenThreeXWhenComputerCheckMediumIsInvokedThenReturnTrue() {
        boolean computerCheckMediumTrue = checker.computerCheckMedium('X', 'X', 'X');
        Assertions.assertTrue(computerCheckMediumTrue);
    }

    @Test
    public void givenThreeDifferentCharsWhenComputerCheckMediumIsInvokedThenReturnTrue() {
        boolean computerCheckMediumFalse = checker.computerCheckMedium('X', 'O', 'X');
        Assertions.assertFalse(computerCheckMediumFalse);
    }

    @Test
    public void givenCrossToAddWhenInsideLoopComputerIsInvokedThenCrossIsAddedHell() {
        Mockito.when(mockedInserter.computerOpponentInsertingCircleHellLvl(gameBoard)).thenReturn(xBoard);
        char[] test = checker.computerTurn(HELL, gameBoard, mockedInserter);
        Assertions.assertArrayEquals(test, xBoard);
    }
}
