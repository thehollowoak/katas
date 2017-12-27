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

    @Test
    public void twoPiecesOnBoardGivesOneOption() {
        reversi.setBoard(twoPiecesOnBoard);

        reversi.getLegalMoves();

        assertEquals(twoPiecesOnBoardWithMoves, reversi.getBoardAsString());
    }

    private String threePiecesOnBoard = 
        "........" +
        "........" +
        "........" +
        "...B...." +
        "...WB..." +
        "........" +
        "........" +
        "........" + "W";
    private String threePiecesOnBoardWithMoves = 
        "........" +
        "........" +
        "...O...." +
        "...B...." +
        "...WBO.." +
        "........" +
        "........" +
        "........" + "W";
        
    @Test
    public void threePiecesOnBoardGivesTwoOptions() {
        reversi.setBoard(threePiecesOnBoard);

        reversi.getLegalMoves();

        assertEquals(threePiecesOnBoardWithMoves, reversi.getBoardAsString());
    }

}