package pl.kamilsieczkowski.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MenuTest {
    private Menu mockedMenu;
    private Menu menu;

    @BeforeEach
    public void setUp() {
        //given
        mockedMenu = Mockito.mock(Menu.class);
        menu = new Menu();
    }

    @Test
    public void givenDisplayMenuMethodWhenInvokedShouldReturnTrue() {
        mockedMenu.displayMenu();
        Mockito.verify(mockedMenu).displayMenu();
    }

    @Test
    public void givenDisplayPlayWithComputerMethodWhenInvokedShouldReturnTrue() {
        mockedMenu.displayPlayWithComputer();
        Mockito.verify(mockedMenu).displayPlayWithComputer();
    }
}
