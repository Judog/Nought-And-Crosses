package pl.kamilsieczkowski.game;

import pl.kamilsieczkowski.game.levels.Game;
import pl.kamilsieczkowski.game.levels.GameWithOtherPlayer;
import pl.kamilsieczkowski.utils.inserters.Inserter;

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
    public void displayMenu(GameWithOtherPlayer gameWithOtherPlayer) {
        Game game = new Game(board.setStartBoard(), board, inserter);
        scanner = new Scanner(System.in);
        System.out.println(PLAY_WITH_COMPUTER);
        System.out.println(PLAY_WITH_OTHER_PERSON);
        System.out.println(EXIT);
        int insert = scanner.nextInt();
        if (insert == ONE) {
            displayPlayWithComputer(game);
        } else if (insert == TWO) {
            gameWithOtherPlayer.playGame();
        } else if (insert == THREE) {
            System.exit(0);
        } else {
            System.out.println(NUMBER_FROM_1_TO_3);
            displayMenu(gameWithOtherPlayer);
        }
    }

    /**
     * displays menu to start game with computer
     */
    void displayPlayWithComputer(Game game) {

        System.out.println(EASY_MODE);
        System.out.println(MEDIUM_MODE);
        System.out.println(HELL_MODE);
        int insert = scanner.nextInt();
        if (insert == ONE) {
        } else if (insert == TWO) {
            game.playGame(MEDIUM);
        } else if (insert == THREE) {
            game.playGame(HELL);
        } else {
            System.out.println(NUMBER_FROM_1_TO_3);
            displayPlayWithComputer(game);
        }
    }
}
