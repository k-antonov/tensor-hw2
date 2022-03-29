package com.example.main.homework2.gambling;

public enum Suit {
    CLUBS(0),
    DIAMONDS(1),
    SPADES(2),
    HEARTS(3);

    private final int value;
    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
