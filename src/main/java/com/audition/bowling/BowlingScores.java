package com.audition.bowling;

public class BowlingScores {

    private BowlingFrame[] frames;

    public void setFrames(String input) {
        String[] rolls = input.split(" ");
        frames = new BowlingFrame[rolls.length];
        BowlingFrame next = null;
        for(int i = 9; i >= 0; i--) {
            frames[i] = new BowlingFrame(rolls[i], next);
        }
    }

    public int getScore() {
        int totalScore = 0;
        for(BowlingFrame frame : frames) {
            totalScore += frame.score;
        }
        return totalScore;
    }

}