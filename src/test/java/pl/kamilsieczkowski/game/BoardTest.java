package pl.kamilsieczkowski.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardTest {
    private static Board board;
    private static char[] givenBoard;
    private static Board mockedBoard;
    private static char[] boardForGame;

    @BeforeAll
    public static void setUp() {
        boardForGame = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        board = new Board();
        givenBoard = board.setStartBoard();
        mockedBoard = Mockito.mock(Board.class);
    }

    @Test
    public void givenBoardForGameWhenEqualsWithReturnOfSetStartBoardShouldPrintTrue() {
        char[] startBoard = board.setStartBoard();
        Assertions.assertArrayEquals(startBoard, boardForGame);
    }

    @Test
    public void givenBoardWhenInvokedBySetStartBoardShouldHaveSize9() {
        int sizeOfGivenBoard = givenBoard.length;
        Assertions.assertEquals(sizeOfGivenBoard, 9);
    }

    private void elementOfBoardShouldBeChar(int elementOfBoard) {
        assertThat(givenBoard[elementOfBoard]).isInstanceOf(Character.class);
    }

    @Test
    public void givenElementOfSetStartBoardShouldBeChar() {
        for (int counter = 0; counter < 9; counter++) {
            elementOfBoardShouldBeChar(counter);
        }
    }

    @Test
    public void givenDisplayBoardMethodWhenInvokedShouldReturnTrue() {
        mockedBoard.displayBoard(boardForGame);
        Mockito.verify(mockedBoard, Mockito.times(1)).displayBoard(boardForGame);
    }
}
