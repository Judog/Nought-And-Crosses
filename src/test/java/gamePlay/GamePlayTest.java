package gamePlay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class GamePlayTest {
    private char[] firstRowX;
    private char[] secondRowX;
    private char[] thirdRowX;
    private char[] firstColumnX;
    private char[] secondColumnX;
    private char[] thirdColumnX;
    private char[] leftSlantX;
    private char[] rightSlantX;
    private char[] mockedBoard;
    private static GamePlay mockedGamePlay;
    private static GamePlay gamePlay;


    @BeforeAll
    public static void steUp() {
        mockedGamePlay = Mockito.mock(GamePlay.class);
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
        mockedGamePlay.playGame();
        Mockito.verify(mockedGamePlay).playGame();
    }
    @Test
    public void shouldDisplayWinRequirementsCheck(){
        mockedGamePlay.winRequirementsCheck();
        Mockito.verify(mockedGamePlay).winRequirementsCheck();
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenFirstRowXGiven() {
        gamePlay = new GamePlay(firstRowX);
        boolean methodAssertion = gamePlay.multipleConditionsCheck();
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenFirstRowXGiven() {
        gamePlay = new GamePlay(firstRowX);
        boolean methodAssertion = gamePlay.conditionsCheck(0, 1, 2);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenSecondRowXGiven() {
        gamePlay = new GamePlay(secondRowX);
        boolean methodAssertion = gamePlay.multipleConditionsCheck();
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenSecondRowXGiven() {
        gamePlay = new GamePlay(secondRowX);
        boolean methodAssertion = gamePlay.conditionsCheck(3, 4, 5);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenThirdRowXGiven() {
        gamePlay = new GamePlay(thirdRowX);
        boolean methodAssertion = gamePlay.multipleConditionsCheck();
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenThirdRowXGiven() {
        gamePlay = new GamePlay(thirdRowX);
        boolean methodAssertion = gamePlay.conditionsCheck(6, 7, 8);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenFirstColumnXGiven() {

        gamePlay = new GamePlay(firstColumnX);
        boolean methodAssertion = gamePlay.multipleConditionsCheck();
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenFirstColumnXGiven() {
        gamePlay = new GamePlay(firstColumnX);
        boolean methodAssertion = gamePlay.conditionsCheck(0, 3, 6);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenSecondColumnXGiven() {

        gamePlay = new GamePlay(secondColumnX);
        boolean methodAssertion = gamePlay.multipleConditionsCheck();
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenSecondColumnXGiven() {
        gamePlay = new GamePlay(secondColumnX);
        boolean methodAssertion = gamePlay.conditionsCheck(1, 4, 7);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenThirdColumnXGiven() {

        gamePlay = new GamePlay(thirdColumnX);
        boolean methodAssertion = gamePlay.multipleConditionsCheck();
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenThirdColumnXGiven() {
        gamePlay = new GamePlay(thirdColumnX);
        boolean methodAssertion = gamePlay.conditionsCheck(2, 5, 8);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenRightSlantXGiven() {
        gamePlay = new GamePlay(rightSlantX);
        boolean methodAssertion = gamePlay.multipleConditionsCheck();
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenRightSlantXGiven() {
        gamePlay = new GamePlay(rightSlantX);
        boolean methodAssertion = gamePlay.conditionsCheck(0, 4, 8);
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void multipleConditionsShouldReturnTrueWhenLeftSlantXGiven() {
        gamePlay = new GamePlay(leftSlantX);
        boolean methodAssertion = gamePlay.multipleConditionsCheck();
        Assertions.assertTrue(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenLeftSlantXGiven() {
        gamePlay = new GamePlay(leftSlantX);
        boolean methodAssertion = gamePlay.conditionsCheck(2, 4, 6);
        Assertions.assertTrue(methodAssertion);
    }
    @Test
    public void multipleConditionsShouldReturnFalseWhenStartBoardGameXGiven() {
        gamePlay = new GamePlay(mockedBoard);
        boolean methodAssertion = gamePlay.multipleConditionsCheck();
        Assertions.assertFalse(methodAssertion);
    }

    @Test
    public void ConditionsCheckShouldReturnTrueWhenStartBoardGameXGiven() {
        gamePlay = new GamePlay(mockedBoard);
        boolean methodAssertion = gamePlay.conditionsCheck(2, 4, 6);
        Assertions.assertFalse(methodAssertion);
    }
@Test
    public void whenWinnerCheckIsMockedItMustRun(){
        mockedGamePlay.checkAWinner(1,2,3);
        Mockito.verify(mockedGamePlay).checkAWinner(1,2,3);
}
}
