package com.audition.bowling;
import java.util.*;

public class BowlingFrame {

    int score;
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
    }

    public BowlingFrame(String input) {
        char[] rolls = input.toCharArray();
        for (char roll : rolls) {
            score += scoreMap.get(roll);
        }
    }

}