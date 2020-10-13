package pl.kamilsieczkowski.utils;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static pl.kamilsieczkowski.constants.Constants.CIRCLE;
import static pl.kamilsieczkowski.constants.Constants.CROSS;


public class InserterTest {
    private Inserter inserter;
    private Inserter mockedInserter;
    private char[] board;


    @BeforeEach
    public void setUp() {
        inserter = new Inserter();
        board = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        mockedInserter = Mockito.mock(Inserter.class);
    }

    @Test
    public void shouldAssertWhenMethodInsertsCircle() {
        char[] methodReturnArray = inserter.computerOpponentInsertingCircles(board);
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
            shouldReturnBoardWithCrossWhenHaveBoardAndNumber(board, boardPlace);
        }
    }

    private void shouldReturnBoardWithCrossWhenHaveBoardAndNumber(char[] board, int arrayPlace) {
        char[] boardWithCross = inserter.addCrossOrCircleToBoard(board, arrayPlace, CROSS);
        Assertions.assertEquals(boardWithCross[arrayPlace], CROSS);
    }

    @Test
    public void shouldAddCircleToGameBoardToEndGameInMediumLevel() {
        char[] mockedBoard = new char[]{'O', 'O', '3', '4', '5', '6', '7', '8', '9'};
        char[] shouldBeBoard = new char[]{'O', 'O', 'O', '4', '5', '6', '7', '8', '9'};
        char[] insertedBoard = inserter.computerOpponentInsertCirclesMediumLvl(mockedBoard);
        Assertions.assertArrayEquals(shouldBeBoard, insertedBoard);
    }

    @Test
    public void shouldAddCircleToGameBoardBlockOpponentInHellLevel() {
        char[] mockedBoard = new char[]{'X', 'X', '3', '4', '5', '6', '7', '8', '9'};
        char[] shouldBeBoard = new char[]{'X', 'X', 'O', '4', '5', '6', '7', '8', '9'};
        char[] insertedBoard = inserter.computerOpponentInsertCirclesHellLvl(mockedBoard);
        Assertions.assertArrayEquals(shouldBeBoard, insertedBoard);
    }
}
