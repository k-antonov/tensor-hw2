package com.example.main.homework2.gambling;

public enum Rank {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),
    ACE("Ace"),
    JOKER("Joker");

    private final String title;

    Rank(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}