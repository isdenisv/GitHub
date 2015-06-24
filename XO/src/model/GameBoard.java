package model;

public class GameBoard {

    public static final int NUMBER_OF_CELL = 2;

    public final char[][] board = new char[NUMBER_OF_CELL][NUMBER_OF_CELL];

    public void setFigureToXY(int x, int y, char figure) {
        this.board[x][y] = figure;
    }


}
