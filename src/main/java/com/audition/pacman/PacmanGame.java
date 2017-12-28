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
        Point position;
        Direction direction;
        Pacman() {
            position = new Point(BOARD_HIGHT/2, BOARD_WIDTH/2);
            direction = RIGHT;
        }

        void move() {
            position.translate(direction);
        }
    }

    public PacmanGame() {
        board = new Icon[BOARD_HIGHT][BOARD_WIDTH];
        pacman = new Pacman();
        fillBoard();
    }

    public void tick() {
        setIconAtPoint(pacman.position, EMPTY);
        pacman.move();
        setIconAtPoint(pacman.position, PACMAN);
    }

    public void rotate(Direction d) {
        pacman.direction = d;
    }

    public Direction getDirection() {
        return pacman.direction;
    }

    public Point getPosition() {
        return new Point(pacman.position);
    }

    public Icon getIconAtPoint(Point p) {
        return board[p.getX()][p.getY()];
    }

    private void setIconAtPoint(Point p, Icon i) {
        board[p.getX()][p.getY()] = i;
    }

    private void fillBoard() {
        for(Icon[] row : board) {
            Arrays.fill(row, DOT);
        }
        Arrays.fill(board[0], WALL);
        Arrays.fill(board[BOARD_HIGHT-1], WALL);
        board[pacman.position.getX()][pacman.position.getY()] = PACMAN;
    }
}