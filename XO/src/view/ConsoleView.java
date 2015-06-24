package view;

import model.GameBoard;
import model.Players;

import java.util.Scanner;

public class ConsoleView {

    public void showBoard(GameBoard gameBoard) {
        for (int i = 0; i < GameBoard.NUMBER_OF_CELL; i++) {
            for (int j = 0; j < GameBoard.NUMBER_OF_CELL; j++) {
                System.out.print(gameBoard.board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void showPlayers(Players players) {
        System.out.println(players.firstPlayerName + " " + Players.figureOfFirstPlayer);
        System.out.println(players.secondPlayerName + " " + Players.figureOfSecondPlayer);
    }

    public static void sayGetMove() {
        System.out.printf("Input coordinate:");
    }

    public static void sayAboutError() {
        System.out.printf("Your coordinate is wrong, try again.");
    }

    public static int getCoordinateX() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static int getCoordinateY() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

}
