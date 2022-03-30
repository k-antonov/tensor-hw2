package com.example.main.homework2.gambling;

public enum Rank {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    JACK("Jack", 10),
    QUEEN("Queen", 11),
    KING("King", 12),
    ACE("Ace", 13),
    JOKER("Joker", 14);

    private final String name;
    private final int value;

    Rank(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static Rank fromValue(int value) {
        for (Rank rank : Rank.values()) {
            if (value == rank.value) {
                return rank;
            }
        }
        throw new IllegalArgumentException("No rank with value " + value + " found");
    }
}
