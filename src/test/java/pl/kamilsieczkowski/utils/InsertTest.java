package pl.kamilsieczkowski.utils;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;


public class InsertTest {
    private Insert insert;
    private Insert mockedInsert;
    private char[] board;


    @BeforeEach
    public void setUp() {
        insert = new Insert();
        board = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        mockedInsert = Mockito.mock(Insert.class);
    }

    @Test
    public void shouldAssertWhenMethodInsertsCircle() {
        char[] methodReturnArray = insert.computerOpponentInsertingCircles(board);
        int placeOfCircle = 0;
        for (int placeOnBorder = 0; placeOnBorder < 9; placeOnBorder++) {
            if (methodReturnArray[placeOnBorder] == 'O') {
                placeOfCircle = placeOnBorder;
            }
        }
        Assertions.assertEquals(methodReturnArray[placeOfCircle], 'O');
    }

    @Test
    public void shouldReturnBoardWithCrossOnEveryPlaceInBoard() {

        for (int boardPlace = 0; boardPlace < 9; boardPlace++) {
            shouldReturnBoardWithCrossWhenHaveBoardAndNumber(board, boardPlace);
        }
    }

    private void shouldReturnBoardWithCrossWhenHaveBoardAndNumber(char[] board, int arrayPlace) {
        char[] boardWithCross = insert.addCrossOrCircleToBoard(board, arrayPlace, 'X');
        Assertions.assertEquals(boardWithCross[arrayPlace], 'X');
    }
}
