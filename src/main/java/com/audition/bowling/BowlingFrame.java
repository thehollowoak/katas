package com.audition.bowling;

public class BowlingFrame {

    int score;

    public BowlingFrame(String input) {
        char[] rolls = input.toCharArray();
        for (char roll : rolls) {
            score += Character.getNumericValue(roll);
        }
    }

}