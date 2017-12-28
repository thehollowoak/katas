package com.audition.bowling;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class BowlingScoresTest {

    private BowlingScores bowling;

    @Before
    public void setup() {
        bowling = new BowlingScores();
    }

    @Test
    public void scoreGameWithOnlyNumbers() {
        bowling.setFrames("11 22 33 44 14 23 32 41 24 31");

        int score = bowling.getScore();

        assertEquals(50, score);
    }

    @Test
    public void scoreGameWithMisses() {
        bowling.setFrames("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-");

        int score = bowling.getScore();

        assertEquals(90, score);
    }

    @Test
    public void scoreGameWithSpares() {
        bowling.setFrames("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5");

        int score = bowling.getScore();

        assertEquals(150, score);
    }

    @Test
    public void scoreGameWithStrikes() {
        bowling.setFrames("X X X X X X X X X X X X");

        int score = bowling.getScore();

        assertEquals(300, score);
    }
}