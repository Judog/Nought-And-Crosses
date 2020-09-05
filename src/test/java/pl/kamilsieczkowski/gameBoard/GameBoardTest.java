package pl.kamilsieczkowski.gameBoard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameBoardTest {
    private static GameBoard gameBoard;
    private static char[] givenBoard;
    @Mock
    private static GameBoard mockedGameBoard;
    char[] boardForGame;

    @BeforeAll
    public static void setUp() {
        gameBoard = new GameBoard();
        givenBoard = gameBoard.setBoard();
        mockedGameBoard = Mockito.mock(GameBoard.class);
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
        mockedGameBoard.displayBoard(boardForGame);
        Mockito.verify(mockedGameBoard, Mockito.times(1)).displayBoard(boardForGame);
    }
}
