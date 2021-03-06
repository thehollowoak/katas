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

    private String fourPiecesOnBoard = 
        "........" +
        "........" +
        "........" +
        "...BW..." +
        "...WB..." +
        "........" +
        "........" +
        "........" + "B";
    private String fourPiecesOnBoardWithMoves = 
        "........" +
        "........" +
        "....O..." +
        "...BWO.." +
        "..OWB..." +
        "...O...." +
        "........" +
        "........" + "B";
        
    @Test
    public void fourPiecesOnBoardGivesFourOptions() {
        reversi.setBoard(fourPiecesOnBoard);

        reversi.getLegalMoves();

        assertEquals(fourPiecesOnBoardWithMoves, reversi.getBoardAsString());
    }

    private String multipleOpponentPiecesInRow = 
        "........" +
        "...B...." +
        "...B...." +
        "...B...." +
        "...WBB.." +
        "........" +
        "........" +
        "........" + "W";
    private String multipleOpponentPiecesInRowWithMoves = 
        "...O...." +
        "...B...." +
        "...B...." +
        "...B...." +
        "...WBBO." +
        "........" +
        "........" +
        "........" + "W";
        
    @Test
    public void multipleOpponentPiecesInRowStillGivesLegalMoves() {
        reversi.setBoard(multipleOpponentPiecesInRow);

        reversi.getLegalMoves();

        assertEquals(multipleOpponentPiecesInRowWithMoves, reversi.getBoardAsString());
    }

    private String piecesInCorner = 
        "BBW....." +
        "BW......" +
        "........" +
        "........" +
        "........" +
        "........" +
        "........" +
        "........" + "W";
        
    @Test
    public void piecesInCornerDoesntGoOutOfBounds() {
        reversi.setBoard(piecesInCorner);

        reversi.getLegalMoves();

        assertEquals(piecesInCorner, reversi.getBoardAsString());
    }
    
    // board taken from below image which shows all legal options
    // https://lh3.ggpht.com/FKh-YJNP_61f_Iv0WS0VvlxZpWZuNgXnKdsL-nUik9GxJRCJjTQ15cSUKsMRmdYhd_E=h900
    private String complicatedSetup = 
        "W..WB.B." +
        ".WWWBB.." +
        "BWWWBBBB" +
        ".W.BW.B." +
        "..WWBW.." +
        "...W.B.." +
        "..W...B." +
        ".......B" + "B";
    private String complicatedSetupWithMoves = 
        "W.OWB.B." +
        "OWWWBB.." +
        "BWWWBBBB" +
        ".WOBWOB." +
        "OOWWBWO." +
        ".OOWOB.." +
        "..WOO.B." +
        ".O.....B" + "B";
        
    @Test
    public void complicatedSetup() {
        reversi.setBoard(complicatedSetup);

        reversi.getLegalMoves();

        assertEquals(complicatedSetupWithMoves, reversi.getBoardAsString());
    }

}