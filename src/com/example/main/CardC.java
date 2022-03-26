package com.example.main;

public class CardC extends CardB {
    public static int maxRank = 2;
    public CardC(int rank, int suit) {
        super(rank, suit);
    }

    public CardC(int suit) {
        super(maxRank + 1, suit);
    }
}
