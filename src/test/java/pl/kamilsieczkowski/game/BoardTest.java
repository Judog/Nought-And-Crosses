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
    @Mock
    private static Board mockedBoard;
    char[] boardForGame;

    @BeforeAll
    public static void setUp() {
        board = new Board();
        givenBoard = board.setStartBoard();
        mockedBoard = Mockito.mock(Board.class);
    }

    @Test
    public void shouldInitiate9elementsBoard() {
        //given
        //when
        int sizeOfGivenBoard = givenBoard.length;
        //then
        Assertions.assertEquals(sizeOfGivenBoard, 9);
    }

    private void elementOfBoardShouldBeChar(int elementOfBoard) {
        //then
        assertThat(givenBoard[elementOfBoard]).isInstanceOf(Character.class);
    }

    @Test
    public void shouldBeCharInEveryElementOfBoard() {
        //when
        for (int counter = 0; counter < 9; counter++) {
            //given
            elementOfBoardShouldBeChar(counter);
        }
    }

    @Test
    public void shouldDisplayBoard() {
        boardForGame = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        mockedBoard.displayBoard(boardForGame);
        Mockito.verify(mockedBoard, Mockito.times(1)).displayBoard(boardForGame);
    }
}
