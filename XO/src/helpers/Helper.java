package helpers;

import model.GameBoard;
import view.ConsoleView;

public class Helper {

    public static boolean checkXCoordinate(int x) {
        if (x < 0 || x >= GameBoard.NUMBER_OF_CELL) {
            ConsoleView.sayAboutError();
            return false;
        }
        return true;
    }

    public static boolean checkYCoordinate(int y) {
        if (y < 0 || y >= GameBoard.NUMBER_OF_CELL) {
            ConsoleView.sayAboutError();
            return false;
        }
        return true;
    }

    public static void hello() {
        System.out.println();
    }

    public static void helllo() {
        System.out.println();
    }

}
