package com.audition.bowling;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class BowlingFrameTest {

    private BowlingFrame frameOne;
    private BowlingFrame frameTwo;
    private BowlingFrame frameThree;

    @Before
    public void before() {
        frameOne = null;
        frameTwo = null;
        frameThree = null;
    }

    @Test
    public void singleFrameWithNumbersGivesProperScore() {
        frameOne = new BowlingFrame("54", null);

        assertEquals(9, frameOne.score);
    }

    @Test
    public void singleFrameWithMissesGivesProperScore() {
        frameOne = new BowlingFrame("-4", null);

        assertEquals(4, frameOne.score);
    }

    @Test
    public void frameWithSpareGivesProperScore() {
        frameTwo = new BowlingFrame("45", null);
        frameOne = new BowlingFrame("3/", frameTwo);

        assertEquals(14, frameOne.score);
    }

    @Test
    public void frameWithStrikeGivesProperScore() {
        frameTwo = new BowlingFrame("45", null);
        frameOne = new BowlingFrame("X", frameTwo);

        assertEquals(19, frameOne.score);
    }

    @Test
    public void threeStrikesInARowIs30Points() {
        BowlingFrame frameFour = new BowlingFrame("--", null);
        frameThree = new BowlingFrame("X", frameFour);
        frameTwo = new BowlingFrame("X", frameThree);
        frameOne = new BowlingFrame("X", frameTwo);

        assertEquals(30, frameOne.score);
    }

    @Test
    public void spareThenStrikeIs20Points() {
        frameThree = new BowlingFrame("--", null);
        frameTwo = new BowlingFrame("X", frameThree);
        frameOne = new BowlingFrame("9/", frameTwo);

        assertEquals(20, frameOne.score);
    }

    @Test
    public void strikeThenSpareIs20Points() {
        frameThree = new BowlingFrame("--", null);
        frameTwo = new BowlingFrame("9/", frameThree);
        frameOne = new BowlingFrame("X", frameTwo);

        assertEquals(20, frameOne.score);
    }

    @Test
    public void endFrameWithSpare() {
        frameOne = new BowlingFrame("9/5");

        assertEquals(15, frameOne.score);
    }

    @Test
    public void endFrameWithStrike() {
        frameOne = new BowlingFrame("X15");

        assertEquals(16, frameOne.score);
    }
}