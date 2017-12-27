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
                checkForMovesFromPoint(i, j);
            }
        }
    }

    private void checkForMovesFromPoint(int i, int j) {
        if (board[i][j] == player) {
            for(Direction d : Direction.values()) {
                if (getTokenOnBoardOrNull(i+d.getX(), j+d.getY()) == player.opponent()) {
                    checkForMoveInDirection(i+d.getX()*2, j+d.getY()*2, d);
                }
            }
        }
    }

    private void checkForMoveInDirection(int i, int j, Direction d) {
        if (getTokenOnBoardOrNull(i, j) == player.opponent()) {
            checkForMoveInDirection(i+d.getX(), j+d.getY(), d);
        }
        else if (getTokenOnBoardOrNull(i, j) == Token.EMPTY) {
            board[i][j] = Token.LEGAL_MOVE;
        }
    }

    private Token getTokenOnBoardOrNull(int x, int y) {
        if (x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE) {
            return board[x][y];
        }
        return null;
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