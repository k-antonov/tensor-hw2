package com.example.main.homework2.gambling;

import java.util.Set;

public abstract class CardB extends Card {
//    protected static final Set<Integer> KNOWN_SUITS = Set.of(DIAMONDS, CLUBS, HEARTS, SPADES);

//    protected final int rank;
//    protected final int suit;

    public CardB(Rank rank, Suit suit) {
//        checkSuit(suit);
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

//    protected final void checkSuit(Suit suit) {
//        if (!KNOWN_SUITS.contains(suit)) {
//            throw new IllegalArgumentException("Wrong suit value " + suit);
//        }
//    }
}
