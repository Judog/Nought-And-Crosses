package pl.kamilsieczkowski.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CheckTest {
    private char[] firstRowX;
    private char[] secondRowX;
    private char[] thirdRowX;
    private char[] firstColumnX;
    private char[] secondColumnX;
    private char[] thirdColumnX;
    private char[] leftSlantX;
    private char[] rightSlantX;
    private char[] mockedBoard;
    private static Check mockedCheck;
    private static Check check;
    private static Insert spyInsert;


    @BeforeAll
    public static void steUp() {
        check = new Check();
        mockedCheck = Mockito.mock(Check.class);
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
        mockedCheck.winRequirementsCheckEasyLvl(mockedBoard);
        Mockito.verify(mockedCheck).winRequirementsCheckEasyLvl(mockedBoard);
    }

    @Test
    public void givenWinRequirementsCheckMediumMethodWhenInvokedShouldReturnTrue() {
        mockedCheck.winRequirementsCheckMedium(mockedBoard);
        Mockito.verify(mockedCheck).winRequirementsCheckMedium(mockedBoard);
    }

    @Test
    public void givenWinRequirementsCheckHellMethodWhenInvokedShouldReturnTrue() {
        mockedCheck.winRequirementsCheckHell(mockedBoard);
        Mockito.verify(mockedCheck).winRequirementsCheckHell(mockedBoard);
    }

    @Test
    public void givenCheckAWinnerMethodWhenInvokedShouldReturnTrue() {
        mockedCheck.checkAWinner(1, 2, 3, rightSlantX);
        Mockito.verify(mockedCheck).checkAWinner(1, 2, 3, rightSlantX);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenFirstRowXGiven() {
        boolean methodAssertion = check.multipleConditionsCheck(firstRowX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenFirstRowXGiven() {
        boolean methodAssertion = check.conditionsCheck(0, 1, 2, firstRowX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenSecondRowXGiven() {
        boolean methodAssertion = check.multipleConditionsCheck(secondRowX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenSecondRowXGiven() {
        boolean methodAssertion = check.conditionsCheck(3, 4, 5, secondRowX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenThirdRowXGiven() {
        boolean methodAssertion = check.multipleConditionsCheck(thirdRowX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenThirdRowXGiven() {
        boolean methodAssertion = check.conditionsCheck(6, 7, 8, thirdRowX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenFirstColumnXGiven() {
        boolean methodAssertion = check.multipleConditionsCheck(firstColumnX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenFirstColumnXGiven() {
        boolean methodAssertion = check.conditionsCheck(0, 3, 6, firstColumnX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenSecondColumnXGiven() {
        boolean methodAssertion = check.multipleConditionsCheck(secondColumnX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenSecondColumnXGiven() {
        boolean methodAssertion = check.conditionsCheck(1, 4, 7, secondColumnX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenThirdColumnXGiven() {
        boolean methodAssertion = check.multipleConditionsCheck(thirdColumnX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenThirdColumnXGiven() {
        boolean methodAssertion = check.conditionsCheck(2, 5, 8, thirdColumnX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenRightSlantXGiven() {
        boolean methodAssertion = check.multipleConditionsCheck(rightSlantX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenRightSlantXGiven() {
        boolean methodAssertion = check.conditionsCheck(0, 4, 8, rightSlantX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenLeftSlantXGiven() {
        boolean methodAssertion = check.multipleConditionsCheck(leftSlantX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenLeftSlantXGiven() {
        boolean methodAssertion = check.conditionsCheck(2, 4, 6, leftSlantX);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnFalseWhenStartBoardGameXGiven() {
        boolean methodAssertion = check.multipleConditionsCheck(mockedBoard);
        Assertions.assertFalse(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenStartBoardGameXGiven() {
        boolean methodAssertion = check.conditionsCheck(2, 4, 6, mockedBoard);
        Assertions.assertFalse(methodAssertion);
    }

    @Test
    public void givenFirstRowXAndBlockedWhenInsertCrossesIsBlockedThenInsideLoopHumanReturnFirstRowX() {
        Mockito.doReturn(firstRowX).when(spyInsert).insertCrosses(firstRowX, 'X');
        char[] insideLoopHumanReturn = check.insideLoopHuman(firstRowX, spyInsert);
        Assertions.assertArrayEquals(insideLoopHumanReturn, firstRowX);
    }

    @Test
    public void givenFirstRowXAndBlockedWhenInsertCrossesIsBlockedThenInsideLoopComputerReturnFirstRowX() {
        Mockito.doReturn(firstRowX).when(spyInsert).computerOpponentInsertingCircles(firstRowX);
        char[] insideLoopComputer = check.insideLoopComputerEasyMode(firstRowX, spyInsert);
        Assertions.assertArrayEquals(insideLoopComputer, firstRowX);
    }

    @Test
    public void givenFirstRowXAndBlockedWhenInsertCrossesIsBlockedThenInsideLoopComputerMediumReturnFirstRowX() {
        Mockito.doReturn(firstRowX).when(spyInsert).computerOpponentInsertCirclesMediumLvl(firstRowX);
        char[] insideLoopComputer = check.insideLoopComputerMedium(firstRowX, spyInsert);
        Assertions.assertArrayEquals(insideLoopComputer, firstRowX);
    }

    @Test
    public void agivenFirstRowXAndBlockedWhenInsertCrossesIsBlockedThenInsideLoopComputerMediumReturnFirstRowX() {
        Mockito.doReturn(firstRowX).when(spyInsert).computerOpponentInsertCirclesHellLvl(firstRowX);
        char[] insideLoopComputer = check.insideLoopComputerHellLvl(firstRowX, spyInsert);
        Assertions.assertArrayEquals(insideLoopComputer, firstRowX);
    }

    @Test
    public void computerCheckMediumWhenCharactersAreThisSameThenShouldPrintTrue() {
        boolean computerCheck = check.computerCheckMedium('X', 'X', 'X');
        Assertions.assertEquals(true, computerCheck);
    }

    @Test
    public void computerCheckMediumWhenCharactersAreDifferentThenShouldPrintFalse() {
        boolean computerCheck = check.computerCheckMedium('O', 'X', 'X');
        Assertions.assertEquals(false, computerCheck);
    }

    @Test
    public void whenWinnerCheckIsMockedItMustRun() {
        mockedCheck.checkAWinner(1, 2, 3, mockedBoard);
        Mockito.verify(mockedCheck).checkAWinner(1, 2, 3, mockedBoard);
    }
}

