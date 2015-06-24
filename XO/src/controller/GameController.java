package controller;

import helpers.Helper;
import model.GameBoard;
import model.Players;
import view.ConsoleView;

public class GameController {

    public void startGame() {
        GameBoard gameBoard = new GameBoard();
        ConsoleView consoleView = new ConsoleView();
        getMove(gameBoard);
        consoleView.showBoard(gameBoard);
    }

    public void getMove(GameBoard gameBoard) {  //TODO
        ConsoleView.sayGetMove();
        int x = ConsoleView.getCoordinateX();
        int y = ConsoleView.getCoordinateY();
        if (Helper.checkXCoordinate(x) || Helper.checkYCoordinate(y)) {
            gameBoard.setFigureToXY(x, y, getFigurePlayer(gameBoard));
        } else {
            ConsoleView.sayAboutError();
        }
    }

    public char getFigurePlayer(GameBoard gameBoard) {
        int countOfFirstFigure = 0, countOfSecondFigure = 0;
        for (int i = 0; i < GameBoard.NUMBER_OF_CELL; i++) {
            for (int j = 0; j < GameBoard.NUMBER_OF_CELL; j++) {
                switch (gameBoard.board[i][j]) {
                    case Players.figureOfFirstPlayer: countOfFirstFigure++;
                        break;
                    case Players.figureOfSecondPlayer: countOfSecondFigure++;
                        break;
                }
            }
        }
        if(countOfFirstFigure == countOfSecondFigure) {
            return Players.figureOfFirstPlayer;
        } else {
            return Players.figureOfSecondPlayer;
        }
    }

    public boolean checkWinner(GameBoard gameBoard) {
        while (true) {
            getMove(gameBoard);
            if (checkVerticalAndHorisontal(gameBoard) || checkDiagonals(gameBoard)) {
                return true;
            }
        }
    }

    private boolean checkDiagonals(GameBoard gameBoard) {
       if (checkLine(gameBoard, 0, 0) || checkLine(gameBoard, 1, -3)) {
           return true;
       }
        return false;
    }

    private boolean checkVerticalAndHorisontal(GameBoard gameBoard) {
        for (int i = 0; i < GameBoard.NUMBER_OF_CELL; i++) {
            if (checkLine(gameBoard, i, 0)) {
                return true;
            }
        }
        for (int i = 0; i < GameBoard.NUMBER_OF_CELL; i++) {
            if (checkLine(gameBoard, 0, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkLine(GameBoard gameBoard, int startI, int srartJ) {
        int countCheck = 0;
        for (int i = 0; i < GameBoard.NUMBER_OF_CELL - 1; i++) {
            if (gameBoard.board[startI][srartJ] == gameBoard.board[startI + 1][srartJ + 1]) {
                countCheck++;
            } else {
                return false;
            }
        }
        if (countCheck == GameBoard.NUMBER_OF_CELL) {
            return true;
        }
        return false;
    }

/*
    public boolean checkWinner(GameBoard gameBoard) {
        while (true) {
            getMove(gameBoard);
            if (checkVertical(gameBoard) || checkHorizontal(gameBoard) || checkRightDiagonal(gameBoard) || checkLeftDiagonal(gameBoard)) {
                return true;
            }
        }
    }


    private boolean checkVertical(GameBoard gameBoard) {
        for (int i = 0; i < GameBoard.NUMBER_OF_CELL; i++) {
            if (gameBoard.board[0][i] == gameBoard.board[1][i] == gameBoard.board[2][i]) {
                if (checkSumbol(gameBoard.board[1][i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkHorizontal(GameBoard gameBoard) {
        for (int i = 0; i < GameBoard.NUMBER_OF_CELL; i++) {
            if (gameBoard.board[i][0] == gameBoard.board[i][1] == gameBoard.board[i][2]) {
                if (checkSumbol(gameBoard.board[i][1])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkRightDiagonal(GameBoard gameBoard) {
        if (gameBoard.board[0][0] == gameBoard.board[1][1] == gameBoard.board[2][2]) {
            if (checkSumbol(gameBoard.board[1][1])) {
                return true;
            }
        }
    }

    private boolean checkLeftDiagonal(GameBoard gameBoard) {
        if (gameBoard.board[2][0] == gameBoard.board[1][1] == gameBoard.board[0][2]) {
            if (checkSumbol(gameBoard.board[3][1])) {
                return true;
            }
        }
    }

    private boolean checkSumbol(char sumboll) {
        if ((sumboll == Players.figureOfFirstPlayer) || (sumboll == Players.figureOfSecondPlayer)) {
            return true;
        }
        return false;
    }
*/

}
