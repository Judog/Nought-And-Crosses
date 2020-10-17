package pl.kamilsieczkowski.utils.inserters;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import pl.kamilsieczkowski.game.Board;

import static pl.kamilsieczkowski.constants.Constants.CIRCLE;
import static pl.kamilsieczkowski.constants.Constants.CROSS;


public class InserterTest {
    private Inserter inserter;

    private char[] gameBoard;


    @BeforeEach
    public void setUp() {
        inserter = new Inserter();
        gameBoard = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    @Test
    public void shouldAssertWhenMethodInsertsCircle() {
        char[] methodReturnArray = inserter.computerOpponentInsertingCircles(gameBoard);
        int placeOfCircle = 0;
        for (int placeOnBorder = 0; placeOnBorder < 9; placeOnBorder++) {
            if (methodReturnArray[placeOnBorder] == CIRCLE) {
                placeOfCircle = placeOnBorder;
            }
        }
        Assertions.assertEquals(methodReturnArray[placeOfCircle], CIRCLE);
    }

    @Test
    public void shouldReturnBoardWithCrossOnEveryPlaceInBoard() {
        for (int boardPlace = 0; boardPlace < 9; boardPlace++) {
            shouldReturnBoardWithCrossWhenHaveBoardAndNumber(gameBoard, boardPlace);
        }
    }

    private void shouldReturnBoardWithCrossWhenHaveBoardAndNumber(char[] board, int arrayPlace) {
        char[] boardWithCross = inserter.addCrossOrCircleToBoard(board, arrayPlace, CROSS);
        Assertions.assertEquals(boardWithCross[arrayPlace], CROSS);
    }

    //
    @Test
    public void givenGameBoardWhenComputerOpponentOnLvlMediumInsertsCircleShouldReturnBoardWithCircle() {
        char[] boardWithCircle = inserter.computerOpponentInsertingCircleMediumLvl(gameBoard);
        int placeOfBoardWithCircle = 0;
        for (int counter = 0; counter < 9; counter++) {
            if (boardWithCircle[counter] == CIRCLE) {
                placeOfBoardWithCircle = counter;
            }
        }
        Assertions.assertEquals(boardWithCircle[placeOfBoardWithCircle], CIRCLE);
    }

    @Test
    public void givenGameBoardWhenComputerOpponentOnLvlHellInsertsCircleShouldReturnBoardWithCircle() {
        char[] boardWithCircle = inserter.computerOpponentInsertingCircleHellLvl(gameBoard);
        int placeOfBoardWithCircle = 0;
        for (int counter = 0; counter < 9; counter++) {
            if (boardWithCircle[counter] == CIRCLE) {
                placeOfBoardWithCircle = counter;
            }
        }
        Assertions.assertEquals(boardWithCircle[placeOfBoardWithCircle], CIRCLE);
    }

    @Test
    public void shouldAddCircleToGameBoardToEndGameInMediumLevel() {
        char[] mockedGameBoard = new char[]{'O', 'O', '3', '4', '5', '6', '7', '8', '9'};
        char[] shouldBeBoard = new char[]{'O', 'O', 'O', '4', '5', '6', '7', '8', '9'};
        char[] insertedBoard = inserter.computerOpponentAI(CIRCLE, mockedGameBoard);
        Assertions.assertArrayEquals(shouldBeBoard, insertedBoard);
    }

    @Test
    public void shouldAddCircleToGameBoardBlockOpponentInHellLevel() {
        char[] mockedGameBoard = new char[]{'X', 'X', '3', '4', '5', '6', '7', '8', '9'};
        char[] shouldBeBoard = new char[]{'X', 'X', 'O', '4', '5', '6', '7', '8', '9'};
        char[] insertedBoard = inserter.computerOpponentAI(CROSS, mockedGameBoard);
        Assertions.assertArrayEquals(shouldBeBoard, insertedBoard);
    }


    @Test
    public void given4XBoardWhenCheckingSumMethodWasInvokedThenShouldReturn4() {
        char[] mockedBoard = new char[]{'X', 'X', 'X', 'X', '5', '6', '7', '8', '9'};
        int sumOfCrosses = inserter.checkingSumOfCrossesOrCircles(mockedBoard, CROSS);
        Assertions.assertEquals(sumOfCrosses, 4);
    }

}
