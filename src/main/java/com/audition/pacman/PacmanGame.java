package com.audition.pacman;
import java.util.Arrays;
import static com.audition.pacman.Icon.*;
import static com.audition.pacman.Direction.*;

public class PacmanGame {

    public static final int BOARD_HIGHT = 20;
    public static final int BOARD_WIDTH = 15;
    Icon[][] board;
    Pacman pacman;

    private class Pacman {
        int x, y;
        Direction direction;
        Pacman() {
            x = BOARD_HIGHT/2;
            y = BOARD_WIDTH/2;
            direction = RIGHT;
        }
    }

    public PacmanGame() {
        board = new Icon[BOARD_HIGHT][BOARD_WIDTH];
        pacman = new Pacman();
        fillBoard();
    }

    public void rotate(Direction d) {
        pacman.direction = d;
    }

    public Direction getDirection() {
        return pacman.direction;
    }

    private void fillBoard() {
        for(Icon[] row : board) {
            Arrays.fill(row, DOT);
        }
        Arrays.fill(board[0], WALL);
        Arrays.fill(board[BOARD_HIGHT-1], WALL);
        board[pacman.x][pacman.y] = PACMAN;
    }
}