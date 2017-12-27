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
}