package com.audition.reversi;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.audition.reversi.Token.*;

public class TokenTest {

    @Test
    public void opponentOfBlackIsWhite() {
        Token player = BLACK;

        Token opponent = player.opponent();

        assertEquals(WHITE, opponent);
    }
    
    @Test
    public void opponentOfWhiteIsBlack() {
        Token player = WHITE;

        Token opponent = player.opponent();

        assertEquals(BLACK, opponent);
    }
    
    @Test
    public void opponentOfEmptyIsNull() {
        Token player = EMPTY;

        Token opponent = player.opponent();

        assertEquals(null, opponent);
    }
    
    @Test
    public void testGetTokenReturnsCorrectToken() {
        Token black = getToken('B');
        Token white = getToken('W');
        Token empty = getToken('.');

        assertEquals(BLACK, black);
        assertEquals(WHITE, white);
        assertEquals(EMPTY, empty);
    }

}