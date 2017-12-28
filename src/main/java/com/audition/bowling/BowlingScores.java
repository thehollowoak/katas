package com.audition.bowling;

public class BowlingScores {

    private BowlingFrame[] frames;

    public void setFrames(String input) {
        String[] rolls = input.split(" ");
        frames = new BowlingFrame[rolls.length];
        frames[9] = new BowlingFrame(rolls[9]);
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

}