package com.audition.pacman;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
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

        assert(boardRowWithPacman.contains(Icon.PACMAN));
        assert(boardRowWithPacman.contains(Icon.DOT));
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
        assertEquals("There is a dot", Icon.DOT, game.getIconAtPoint(dotPos));

        game.tick();
        game.tick();

        assertNotSame("There is not a dot", Icon.DOT, game.getIconAtPoint(dotPos));
    }
}