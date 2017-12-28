package com.audition.bowling;

import java.util.Arrays;

public class BowlingScores {

    private BowlingFrame[] frames;

    public void setFrames(String input) {
        String[] rolls = input.split(" ");
        frames = new BowlingFrame[10];
        frames[9] = new BowlingFrame(getEndFrame(rolls));
        for(int i = 8; i >= 0; i--) {
            frames[i] = new BowlingFrame(rolls[i], frames[i+1]);
        }
    }

    public int getScore() {
        int totalScore = 0;
        for(BowlingFrame frame : frames) {
            totalScore += frame.score;
        }
        return totalScore;
    }

    private String getEndFrame(String[] rolls) {
        String[] endFrames = Arrays.copyOfRange(rolls, 9, rolls.length);
        return String.join("", endFrames);
    }

}