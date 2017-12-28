package com.audition.bowling;
import java.util.*;

public class BowlingFrame {

    int score, bonusForSpare, bonusForStrike;
    private static final char SPARE = '/';
    private static final int SPARE_VALUE = 10;
    private static final char STRIKE = 'X';
    private static final int STRIKE_VALUE = 10;
    private static final HashMap<Character, Integer> scoreMap;
    static
    {
        scoreMap = new HashMap<Character, Integer>();
        scoreMap.put('-', 0);
        scoreMap.put('1', 1);
        scoreMap.put('2', 2);
        scoreMap.put('3', 3);
        scoreMap.put('4', 4);
        scoreMap.put('5', 5);
        scoreMap.put('6', 6);
        scoreMap.put('7', 7);
        scoreMap.put('8', 8);
        scoreMap.put('9', 9);
        scoreMap.put(SPARE, SPARE_VALUE);
        scoreMap.put(STRIKE, STRIKE_VALUE);
    }

    public BowlingFrame(String input, BowlingFrame next) {
        char[] rolls = input.toCharArray();
        if (rolls[0] == STRIKE) {
            scoreStrike(next.bonusForSpare, next.bonusForStrike);
        }
        else if (rolls[1] == SPARE) {
            scoreSpare(next.bonusForSpare);
        }
        else {
            scoreNumbers(rolls);
        }
        bonusForSpare = scoreMap.get(rolls[0]);
    }

    public BowlingFrame(String endFrameInput) {
        char[] rolls = endFrameInput.toCharArray();
        if (rolls[0] == STRIKE) {
            if (rolls[2] == SPARE) {
                scoreStrike(scoreMap.get(rolls[1]), scoreMap.get(rolls[2]));
            }
            else {
                scoreStrike(scoreMap.get(rolls[1]), scoreMap.get(rolls[1]) + scoreMap.get(rolls[2]));
            }
        }
        else if (rolls[1] == SPARE) {
            scoreSpare(scoreMap.get(rolls[2]));
        }
        else {
            scoreNumbers(rolls);
        }
        bonusForSpare = scoreMap.get(rolls[0]);
    }

    private void scoreStrike(int singleBonus, int doubleBonus) {
        score = STRIKE_VALUE + doubleBonus;
        bonusForStrike = STRIKE_VALUE + singleBonus;
    }

    private void scoreSpare(int singleBonus) {
        score = SPARE_VALUE + singleBonus;
        bonusForStrike = SPARE_VALUE;
    }

    private void scoreNumbers(char[] rolls) {
        for (char roll : rolls) {
            score += scoreMap.get(roll);
        }
        bonusForStrike = score;
    }

}