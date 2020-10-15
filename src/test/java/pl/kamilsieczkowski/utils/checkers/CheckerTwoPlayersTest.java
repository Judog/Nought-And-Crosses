package pl.kamilsieczkowski.utils.checkers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.kamilsieczkowski.game.Board;
import pl.kamilsieczkowski.utils.inserters.Inserter;

import static pl.kamilsieczkowski.constants.Constants.CROSS;

public class CheckerTwoPlayersTest {
    private static CheckerTwoPlayers checkerTwoPlayers;
    private static CheckerTwoPlayers mockedCheckerTwoPlayers;
    private static Inserter mockedInserter;
    private static Board mockedBoard;
    private static char[] gameBoard;
    private char[] winBoard;
    private char[] xBoard;

    @BeforeAll
    public static void setUp() {
        mockedInserter = Mockito.mock(Inserter.class);
        mockedBoard = Mockito.mock(Board.class);
        checkerTwoPlayers= new CheckerTwoPlayers(mockedInserter, mockedBoard);
        mockedCheckerTwoPlayers= Mockito.mock(CheckerTwoPlayers.class);
        gameBoard = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    @BeforeEach
    public void invoke() {
        xBoard = new char[]{'X', '2', '3', '4', '5', '6', '7', '8', '9'};
        winBoard = new char[]{'X', 'X', 'X', '4', '5', '6', '7', '8', '9'};

    }

    @Test
    public void givenCrossToAddwhenInsideLoopHumanIsInvokedThenCrossIsAdded() {
        Mockito.when(mockedInserter.insertCrosses(gameBoard, CROSS)).thenReturn(xBoard);
        char[] test = checkerTwoPlayers.insideLoopHuman(gameBoard, mockedInserter, CROSS);
        Assertions.assertArrayEquals(test, xBoard);
    }
}
