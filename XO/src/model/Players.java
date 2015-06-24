package model;

public class Players {

    public String firstPlayerName;

    public static final char figureOfFirstPlayer = 'X';

    public String secondPlayerName;

    public static final char figureOfSecondPlayer = 'O';

    public Players(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

}
