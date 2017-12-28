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
}