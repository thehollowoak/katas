package com.audition.pacman;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import static com.audition.pacman.Icon.*;
import static com.audition.pacman.Direction.*;

public class PacmanGameTest {

    private PacmanGame game;

    @Before
    public void setup() {
        game = new PacmanGame();
    }

    @Test
    public void pacmanIsOnAGridFilledWithDots() {
        List <Icon> boardRowWithPacman = Arrays.asList(game.board[game.BOARD_HIGHT/2]);

        assert(boardRowWithPacman.contains(PACMAN));
        assert(boardRowWithPacman.contains(DOT));
    }

    @Test
    public void pacmanCanBeRotated() {
        game.rotate(UP);

        assertEquals(UP, game.getDirection());
    }

    @Test
    public void pacmanMovesOnTick() {
        game.rotate(UP);
        Point startingPos = game.getPosition();
        game.tick();
        Point endingPos = game.getPosition();

        assertNotSame(startingPos, endingPos);
    }

    @Test
    public void pacmanEatsDots() {
        game.rotate(RIGHT);
        Point dotPos = game.getPosition();
        dotPos.translate(RIGHT);
        assertEquals("There is a dot", DOT, game.getIconAtPoint(dotPos));

        game.tick();
        game.tick();

        assertNotSame("There is not a dot", DOT, game.getIconAtPoint(dotPos));
    }

    @Test
    public void pacmanStopsOnWall() {
        game.rotate(UP);
        
        moveUntilWall();
        Point posInFrontOfWall = game.getPosition();
        game.tick();

        assertEquals(posInFrontOfWall, game.getPosition());
    }

    @Test
    public void pacmanWrapsAround() {
        game.rotate(RIGHT);
        Point startingPos = game.getPosition();
        game.tick();
        
        moveUntilPacmanGetsToPoint(startingPos);

        assertEquals(startingPos, game.getPosition());
    }

    @Test
    public void thereAreGhosts() {
        List <Icon> boardRowWithGhosts = Arrays.asList(game.board[1]);

        assert(boardRowWithGhosts.contains(GHOST));
    }

    @Test
    public void ghostMovesOnTick() {
        Point ghostStartingPoint = new Point(1,1);
        assertEquals(GHOST, game.getIconAtPoint(ghostStartingPoint));

        game.tick();

        assertNotSame(GHOST, game.getIconAtPoint(ghostStartingPoint));        
    }

    @Test
    public void ghostMovesTowardPacman() {
        Point pointBelowGhost = new Point(2,1);
        game.rotate(LEFT);

        game.tick();

        assertEquals(GHOST, game.getIconAtPoint(pointBelowGhost));        
    }

    private void moveUntilWall() {
        Point nextPos = game.getPosition();
        nextPos.translate(game.getDirection());
        int noInfinateLoops = 0;
        while (game.getIconAtPoint(nextPos) != WALL && noInfinateLoops++ < 20) {
            game.tick();
            nextPos.translate(game.getDirection());
        }
    }

    private void moveUntilPacmanGetsToPoint(Point stoppingPoint) {
        int noInfinateLoops = 0;
        while (game.getPosition().getY() != stoppingPoint.getY() && noInfinateLoops++ < 20) {
            game.tick();
        }
    }
}