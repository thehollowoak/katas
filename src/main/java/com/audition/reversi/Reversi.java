package com.audition.reversi;

public class Reversi {

    private Token[][] board;
    private int BOARD_SIZE = 8;
    private Token player;

    public Reversi() {
        board = new Token[BOARD_SIZE][BOARD_SIZE];
    }

    public void setBoard(String inputBoard) {
        char[] input = inputBoard.toCharArray();
        for(int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = Token.getToken(input[i*BOARD_SIZE+j]);
            }
        }
        player = Token.getToken(input[input.length-1]);
    }

    public void getLegalMoves() {
        for(int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == player) {
                    for(int a = -1; a < 2; a++) {
                        for(int b = -1; b < 2; b++) {
                            if (board[i+a][j+b] == player.opponent()) {
                                board[i+a*2][j+b*2] = Token.LEGAL_MOVE;
                            }
                        }
                    }
                }
            }
        }
    }

    public String getBoardAsString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0; j < BOARD_SIZE; j++) {
                sb.append(board[i][j].getSymbol());
            }
        }
        sb.append(player.getSymbol());
        return sb.toString();
    }

}