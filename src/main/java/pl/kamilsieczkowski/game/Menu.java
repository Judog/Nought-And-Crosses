package pl.kamilsieczkowski.game;

import pl.kamilsieczkowski.utils.Check;

import java.util.Scanner;

public class Menu {
    Scanner scanner;
    Board board;
    Game game;
    Check check;

    /**
     * displays menu
     */
    public void displayMenu() {
        board = new Board();
        check = new Check();
        game = new Game(check, board, board.setStartBoard());
        scanner = new Scanner(System.in);
        System.out.println("1. Play with computer");
        System.out.println("2. Play with other Person");
        System.out.println("3. Exit");
        int insert = scanner.nextInt();
        if (insert == 1) {
            displayPlayWithComputer();
        } else if (insert == 2) {
            game.playGameWithOtherPlayer();
        } else if (insert == 3) {
            // nothing here - end of the game
        } else {
            System.out.println("wrong, insert number from 1 to 3");
            displayMenu();
        }
    }

    /**
     * displays menu to start game with computer
     */
    void displayPlayWithComputer() {
        game = new Game(check, board, board.setStartBoard());
        System.out.println("1. Easy Mode");
        System.out.println("2. Medium Mode");
        System.out.println("3. Hell Mode");
        int insert = scanner.nextInt();
        if (insert == 1) {
            game.playGameEasyLvl();
        } else if (insert == 2) {
            game.playGameOnMediumLvl();
        } else if (insert == 3) {
            game.playGameOnHellLvl();
        } else {
            System.out.println("wrong, insert number from 1 to 3");
            displayPlayWithComputer();
        }
    }
}
