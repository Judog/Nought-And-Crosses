package pl.kamilsieczkowski.game;

import pl.kamilsieczkowski.game.levels.GameEasy;
import pl.kamilsieczkowski.game.levels.GameHell;
import pl.kamilsieczkowski.game.levels.GameMedium;
import pl.kamilsieczkowski.game.levels.GameWithOtherPlayer;
import pl.kamilsieczkowski.utils.Checker;

import java.util.Scanner;

import static pl.kamilsieczkowski.constants.Constants.*;
import static pl.kamilsieczkowski.constants.Texts.*;

public class Menu {
    Scanner scanner;
    Board board;

    Checker checker;

    /**
     * displays menu
     */
    public void displayMenu() {
        board = new Board();
        checker = new Checker();
        scanner = new Scanner(System.in);
        System.out.println(playWithComputer);
        System.out.println(playWithOtherPlayer);
        System.out.println(exit);
        int insert = scanner.nextInt();
        if (insert == ONE) {
            displayPlayWithComputer();
        } else if (insert == TWO) {
            GameWithOtherPlayer gameWithOtherPlayer = new GameWithOtherPlayer(board.setStartBoard());
            gameWithOtherPlayer.playGame();
        } else if (insert == THREE) {
            System.exit(0);
        } else {
            System.out.println(wrongNumber);
            displayMenu();
        }
    }

    /**
     * displays menu to start game with computer
     */
    void displayPlayWithComputer() {
        System.out.println(easy);
        System.out.println(medium);
        System.out.println(hell);
        int insert = scanner.nextInt();
        if (insert == ONE) {
            GameEasy gameEasy = new GameEasy(board.setStartBoard());
            gameEasy.playGame();
        } else if (insert == TWO) {
            GameMedium gameMedium = new GameMedium(board.setStartBoard());
            gameMedium.playGame();
        } else if (insert == THREE) {
            GameHell gameHell= new GameHell(board.setStartBoard());
            gameHell.playGame();
        } else {
            System.out.println(wrongNumber);
            displayPlayWithComputer();
        }
    }
}
