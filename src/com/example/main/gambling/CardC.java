package com.example.main.gambling;

import java.util.HashMap;
import java.util.Map;

public class CardC extends CardB {
    public static final Map<Integer, Integer> MAX_RANKS = new HashMap<>();
    public CardC(int rank, int suit) {
        super(rank, suit);
        MAX_RANKS.compute(
            suit,
            (key, maxKnown) -> maxKnown == null ? rank : Math.max(maxKnown, rank)
        );
    }

    public CardC(int suit) {
        this(MAX_RANKS.getOrDefault(suit, 0) + 1, suit);
    }
}
