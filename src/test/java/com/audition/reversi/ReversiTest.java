package com.audition.reversi;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ReversiTest {

    private Reversi reversi;

    @Before
    public void setup() {
        reversi = new Reversi();
    }

    @Test
    public void twoPiecesOnBoardGivesOneOption() {
        reversi.setBoard(twoPiecesOnBoard);

        reversi.getLegalMoves();

        assertEquals(twoPiecesOnBoardWithMoves, reversi.getBoardAsString());
    }

    private String twoPiecesOnBoard = 
        "........" +
        "........" +
        "........" +
        "...B...." +
        "...W...." +
        "........" +
        "........" +
        "........" + "B";
    private String twoPiecesOnBoardWithMoves = 
        "........" +
        "........" +
        "........" +
        "...B...." +
        "...W...." +
        "...O...." +
        "........" +
        "........" + "B";

}