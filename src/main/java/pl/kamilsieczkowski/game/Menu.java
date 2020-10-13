package pl.kamilsieczkowski.game;

import pl.kamilsieczkowski.game.levels.GameEasy;
import pl.kamilsieczkowski.game.levels.GameHell;
import pl.kamilsieczkowski.game.levels.GameMedium;
import pl.kamilsieczkowski.game.levels.GameWithOtherPlayer;
import pl.kamilsieczkowski.utils.Inserter;

import java.util.Scanner;

import static pl.kamilsieczkowski.constants.Constants.*;
import static pl.kamilsieczkowski.constants.Texts.*;

public class Menu {
private Scanner scanner;
private Board board;
private Inserter inserter;

    public Menu(Board board, Inserter inserter) {
        this.board = board;
        this.inserter = inserter;
    }

    /**
     * displays menu
     */
    public void displayMenu() {
        scanner = new Scanner(System.in);
        System.out.println(PLAY_WITH_COMPUTER);
        System.out.println(PLAY_WITH_OTHER_PERSON);
        System.out.println(EXIT);
        int insert = scanner.nextInt();
        if (insert == ONE) {
            displayPlayWithComputer();
        } else if (insert == TWO) {
            GameWithOtherPlayer gameWithOtherPlayer = new GameWithOtherPlayer(board.setStartBoard(), board, inserter);
            gameWithOtherPlayer.playGame();
        } else if (insert == THREE) {
            System.exit(0);
        } else {
            System.out.println(NUMBER_FROM_1_TO_3);
            displayMenu();
        }
    }

    /**
     * displays menu to start game with computer
     */
    void displayPlayWithComputer() {
        System.out.println(EASY_MODE);
        System.out.println(MEDIUM_MODE);
        System.out.println(HELL_MODE);
        int insert = scanner.nextInt();
        if (insert == ONE) {
            GameEasy gameEasy = new GameEasy(board.setStartBoard(), board, inserter);
            gameEasy.playGame();
        } else if (insert == TWO) {
            GameMedium gameMedium = new GameMedium(board.setStartBoard(), board, inserter);
            gameMedium.playGame();
        } else if (insert == THREE) {
            GameHell gameHell = new GameHell(board.setStartBoard(), board, inserter);
            gameHell.playGame();
        } else {
            System.out.println(NUMBER_FROM_1_TO_3);
            displayPlayWithComputer();
        }
    }
}
