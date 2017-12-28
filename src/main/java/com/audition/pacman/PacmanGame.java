package com.audition.pacman;
import java.util.Arrays;
import static com.audition.pacman.Icon.*;

public class PacmanGame {

    public static final int BOARD_HIGHT = 20;
    public static final int BOARD_WIDTH = 15;
    Icon[][] board;

    public PacmanGame() {
        board = new Icon[BOARD_HIGHT][BOARD_WIDTH];
        fillBoard();
    }

    private void fillBoard() {
        for(Icon[] row : board) {
            Arrays.fill(row, DOT);
        }
        Arrays.fill(board[0], WALL);
        Arrays.fill(board[BOARD_HIGHT-1], WALL);
        board[BOARD_HIGHT/2][BOARD_WIDTH/2] = PACMAN;
    }
}