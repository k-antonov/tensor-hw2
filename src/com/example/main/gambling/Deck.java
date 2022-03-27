package com.example.main.gambling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Deck {
    private final ArrayList<DataCardB> list = new ArrayList<>();

    private Deck(boolean withJokers) {
        for (int suit : DataCardB.getSuitNames().keySet()) {
            for (int rank : DataCardB.getRankNames().keySet()) {
                list.add(new DataCardB(rank, suit));
            }
        }
        if (withJokers) {
            list.add(DataCardB.redJoker);
            list.add(DataCardB.blackJoker);
        }
        sort();
    }

    public static Deck buildDeck() {
        return new Deck(false);
    }

    public static Deck buildDeck(boolean withJokers) {
        return new Deck(withJokers);
    }

    public static DataCardB getRandomCard(Deck deck) {
        return deck.list.get(new Random().nextInt(deck.list.size()));
    }

    public void shuffle() {
        Collections.shuffle(list);
    }

    public void sort() {
        list.sort(DataCardB::compareTo);
    }

    public DataCardB dealCard() {
        DataCardB topCard = list.get(list.size() - 1);
        list.remove(topCard);
        return topCard;
    }

    public void returnCard(DataCardB card) throws Exception {
        if (!list.contains(card)) {
            list.add(card);
            return;
        }
        throw new Exception(card + " is already in the deck");
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        String cards = list.stream().map(Objects::toString)
                .collect(Collectors.joining(", "));
        return "Deck = { " + cards + " }";
    }
}
