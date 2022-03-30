package com.example.main.homework2.gambling;

import java.util.HashMap;
import java.util.Map;

public class CardC extends CardB {
    public static final Map<Suit, Integer> MAX_RANKS = new HashMap<>();
    public CardC(Rank rank, Suit suit) {
        super(rank, suit);
        MAX_RANKS.compute(
            suit,
            (key, maxKnown) -> maxKnown == null ? rank.getValue() : Math.max(maxKnown, rank.getValue())
        );
    }

    public CardC(Suit suit) {
        this(Rank.fromValue(MAX_RANKS.getOrDefault(suit, 0) + 1), suit);
    }
}
