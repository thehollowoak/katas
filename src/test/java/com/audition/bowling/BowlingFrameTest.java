package com.audition.bowling;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class BowlingFrameTest {

    private BowlingFrame frame;
    private BowlingFrame frameTwo;

    @Before
    public void before() {
        frame = null;
        frameTwo = null;
    }

    @Test
    public void singleFrameWithNumbersGivesProperScore() {
        frame = new BowlingFrame("54", null);

        assertEquals(9, frame.score);
    }

    @Test
    public void singleFrameWithMissesGivesProperScore() {
        frame = new BowlingFrame("-4", null);

        assertEquals(4, frame.score);
    }

    @Test
    public void frameWithSpareGivesProperScore() {
        frameTwo = new BowlingFrame("45", null);
        frame = new BowlingFrame("3/", frameTwo);

        assertEquals(14, frame.score);
    }

    @Test
    public void frameWithStrikeGivesProperScore() {
        frameTwo = new BowlingFrame("45", null);
        frame = new BowlingFrame("X", frameTwo);

        assertEquals(19, frame.score);
    }
}