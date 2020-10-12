package pl.kamilsieczkowski.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CheckerTest {
    private char[] firstRowX;
    private char[] secondRowX;
    private char[] thirdRowX;
    private char[] firstColumnX;
    private char[] secondColumnX;
    private char[] thirdColumnX;
    private char[] leftSlantX;
    private char[] rightSlantX;
    private char[] mockedBoard;
    private static Checker mockedChecker;
    private static Checker checker;
    private static Insert spyInsert;


    @BeforeAll
    public static void steUp() {
        checker = new Checker();
        mockedChecker = Mockito.mock(Checker.class);
        spyInsert = Mockito.spy(Insert.class);
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
    public void givenWinRequirementsCheckMethodWhenInvokedShouldReturnTrue() {
        mockedChecker.winRequirementsCheckEasyLvl(mockedBoard);
        Mockito.verify(mockedChecker).winRequirementsCheckEasyLvl(mockedBoard);
    }

    @Test
    public void givenWinRequirementsCheckMediumMethodWhenInvokedShouldReturnTrue() {
        mockedChecker.winRequirementsCheckMedium(mockedBoard);
        Mockito.verify(mockedChecker).winRequirementsCheckMedium(mockedBoard);
    }

    @Test
    public void givenWinRequirementsCheckHellMethodWhenInvokedShouldReturnTrue() {
        mockedChecker.winRequirementsCheckHell(mockedBoard);
        Mockito.verify(mockedChecker).winRequirementsCheckHell(mockedBoard);
    }

    @Test
    public void givenCheckAWinnerMethodWhenInvokedShouldReturnTrue() {
        mockedChecker.checkAWinner(1, 2, 3, rightSlantX);
        Mockito.verify(mockedChecker).checkAWinner(1, 2, 3, rightSlantX);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenFirstRowXGiven() {
        boolean methodAssertion = checker.multipleConditionsCheck(firstRowX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenFirstRowXGiven() {
        boolean methodAssertion = checker.conditionsCheck(0, 1, 2, firstRowX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenSecondRowXGiven() {
        boolean methodAssertion = checker.multipleConditionsCheck(secondRowX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenSecondRowXGiven() {
        boolean methodAssertion = checker.conditionsCheck(3, 4, 5, secondRowX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenThirdRowXGiven() {
        boolean methodAssertion = checker.multipleConditionsCheck(thirdRowX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenThirdRowXGiven() {
        boolean methodAssertion = checker.conditionsCheck(6, 7, 8, thirdRowX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenFirstColumnXGiven() {
        boolean methodAssertion = checker.multipleConditionsCheck(firstColumnX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenFirstColumnXGiven() {
        boolean methodAssertion = checker.conditionsCheck(0, 3, 6, firstColumnX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenSecondColumnXGiven() {
        boolean methodAssertion = checker.multipleConditionsCheck(secondColumnX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenSecondColumnXGiven() {
        boolean methodAssertion = checker.conditionsCheck(1, 4, 7, secondColumnX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenThirdColumnXGiven() {
        boolean methodAssertion = checker.multipleConditionsCheck(thirdColumnX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenThirdColumnXGiven() {
        boolean methodAssertion = checker.conditionsCheck(2, 5, 8, thirdColumnX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenRightSlantXGiven() {
        boolean methodAssertion = checker.multipleConditionsCheck(rightSlantX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenRightSlantXGiven() {
        boolean methodAssertion = checker.conditionsCheck(0, 4, 8, rightSlantX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenLeftSlantXGiven() {
        boolean methodAssertion = checker.multipleConditionsCheck(leftSlantX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenLeftSlantXGiven() {
        boolean methodAssertion = checker.conditionsCheck(2, 4, 6, leftSlantX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnFalseWhenStartBoardGameXGiven() {
        boolean methodAssertion = checker.multipleConditionsCheck(mockedBoard);
        Assertions.assertFalse(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenStartBoardGameXGiven() {
        boolean methodAssertion = checker.conditionsCheck(2, 4, 6, mockedBoard);
        Assertions.assertFalse(methodAssertion);
    }

    @Test
    public void givenFirstRowXAndBlockedWhenInsertCrossesIsBlockedThenInsideLoopHumanReturnFirstRowX() {
        Mockito.doReturn(firstRowX).when(spyInsert).insertCrosses(firstRowX, 'X');
        char[] insideLoopHumanReturn = checker.insideLoopHuman(firstRowX, spyInsert);
        Assertions.assertArrayEquals(insideLoopHumanReturn, firstRowX);
    }

    @Test
    public void givenFirstRowXAndBlockedWhenInsertCrossesIsBlockedThenInsideLoopComputerReturnFirstRowX() {
        Mockito.doReturn(firstRowX).when(spyInsert).computerOpponentInsertingCircles(firstRowX);
        char[] insideLoopComputer = checker.insideLoopComputerEasyMode(firstRowX, spyInsert);
        Assertions.assertArrayEquals(insideLoopComputer, firstRowX);
    }

    @Test
    public void givenFirstRowXAndBlockedWhenInsertCrossesIsBlockedThenInsideLoopComputerMediumReturnFirstRowX() {
        Mockito.doReturn(firstRowX).when(spyInsert).computerOpponentInsertCirclesMediumLvl(firstRowX);
        char[] insideLoopComputer = checker.insideLoopComputerMedium(firstRowX, spyInsert);
        Assertions.assertArrayEquals(insideLoopComputer, firstRowX);
    }

    @Test
    public void agivenFirstRowXAndBlockedWhenInsertCrossesIsBlockedThenInsideLoopComputerMediumReturnFirstRowX() {
        Mockito.doReturn(firstRowX).when(spyInsert).computerOpponentInsertCirclesHellLvl(firstRowX);
        char[] insideLoopComputer = checker.insideLoopComputerHellLvl(firstRowX, spyInsert);
        Assertions.assertArrayEquals(insideLoopComputer, firstRowX);
    }

    @Test
    public void computerCheckMediumWhenCharactersAreThisSameThenShouldPrintTrue() {
        boolean computerCheck = checker.computerCheckMedium('X', 'X', 'X');
        Assertions.assertEquals(true, computerCheck);
    }

    @Test
    public void computerCheckMediumWhenCharactersAreDifferentThenShouldPrintFalse() {
        boolean computerCheck = checker.computerCheckMedium('O', 'X', 'X');
        Assertions.assertEquals(false, computerCheck);
    }

    @Test
    public void whenWinnerCheckIsMockedItMustRun() {
        mockedChecker.checkAWinner(1, 2, 3, mockedBoard);
        Mockito.verify(mockedChecker).checkAWinner(1, 2, 3, mockedBoard);
    }
}

