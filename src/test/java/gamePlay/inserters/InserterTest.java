package gamePlay.inserters;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;


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
    public void insertCirclesTest() {
        char[] methodReturnArray = inserter.computerOpponentInsertingCircles(board);
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
        char[] boardWithCross = inserter.addCrossOrCircleToBoard(board, arrayPlace, 'X');
        Assertions.assertEquals(boardWithCross[arrayPlace], 'X');
    }
}
