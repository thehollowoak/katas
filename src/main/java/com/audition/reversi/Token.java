package com.audition.reversi;

public enum Token {
    EMPTY('.'), WHITE('W'), BLACK('B'), LEGAL_MOVE('O');

    private char symbol;
    Token(char c) {
        symbol = c;
    }

    public char getSymbol() {
        return symbol;
    }

    public Token opponent() {
        switch (this) {
            case WHITE: return BLACK;
            case BLACK: return WHITE;
            default: return null;
        }
    }

    public static Token getToken(char symbol) {
        for(Token token : Token.values()) {
            if(token.symbol == symbol) {
                return token;
            }
        }
        return null;
    }
}