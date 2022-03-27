package com.example.main.gambling;

import java.util.Set;

// не наследуюсь от CardA, потому что нельзя public поле переопределить в private.
public abstract class CardB implements Card {
    // считаю, что Set здесь уместнее, чем массив
    protected static final Set<Integer> KNOWN_SUITS = Set.of(DIAMONDS, CLUBS, HEARTS, SPADES);

    protected final int rank;
    protected final int suit;

    public CardB(int rank, int suit) {
        checkSuit(suit);
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    // хотелось бы использовать Enum, но в задании написано проверять значение suit и в случае
    // ошибки выводить соответствующее значение. При использовании Enum проверка не имела бы
    // смысла, т. к. нельзя было бы передать некорректное значение в setSuit(Suit suit)
    protected final void checkSuit(int suit) {
        if (!KNOWN_SUITS.contains(suit)) {
            throw new IllegalArgumentException("Wrong suit value " + suit);
        }
    }
}
