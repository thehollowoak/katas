package com.audition.bowling;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class BowlingFrameTest {

    private BowlingFrame frame;

    @Before
    public void before() {
        frame = null;
    }

    @Test
    public void singleFrameWithNumbersGivesProperScore() {
        frame = new BowlingFrame("54");

        assertEquals(9, frame.score);
    }
}