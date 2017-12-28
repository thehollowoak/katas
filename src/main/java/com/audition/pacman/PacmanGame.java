package com.audition.pacman;
import java.util.Arrays;
import static com.audition.pacman.Icon.*;
import static com.audition.pacman.Direction.*;

public class PacmanGame {

    public static final int BOARD_HIGHT = 20;
    public static final int BOARD_WIDTH = 15;
    Icon[][] board;
    PacmanOrGhost pacman;
    PacmanOrGhost blinky;

    private class PacmanOrGhost {
        Point position;
        Direction direction;
        PacmanOrGhost(Point position) {
            this.position = position;
            direction = RIGHT;
        }

        void move() {
            position.translate(direction);
            if (position.getY() < 0) {
                position = new Point(position.getX(), position.getY() + BOARD_WIDTH);
            }
            else if (position.getY() >= BOARD_WIDTH) {
                position = new Point(position.getX(), position.getY() - BOARD_WIDTH);
            }
        }
    }

    public PacmanGame() {
        board = new Icon[BOARD_HIGHT][BOARD_WIDTH];
        pacman = new PacmanOrGhost(new Point(BOARD_HIGHT/2, BOARD_WIDTH/2));
        blinky = new PacmanOrGhost(new Point(1,1));
        fillBoard();
    }

    public void tick() {
        Point next = getPosition();
        next.translate(pacman.direction);
        if (getIconAtPoint(next) != WALL) {
            setIconAtPoint(pacman.position, EMPTY);
            pacman.move();
            setIconAtPoint(pacman.position, PACMAN);
        }
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
        if (isPointOnBoard(p)) {
            return board[p.getX()][p.getY()];
        }
        return null;
    }

    private boolean isPointOnBoard(Point p) {
        return p.getX() >= 0 && p.getX() < BOARD_HIGHT && p.getY() >= 0 && p.getY() < BOARD_WIDTH; 
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
        board[blinky.position.getX()][blinky.position.getY()] = GHOST;
    }
}