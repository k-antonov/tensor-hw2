package com.example.main.homework2.gambling;

import org.jetbrains.annotations.NotNull;

public class DataCardB extends CardB implements Comparable {
    public static final DataCardB redJoker = new DataCardB(Rank.JOKER, Suit.HEARTS);
    public static final DataCardB blackJoker = new DataCardB(Rank.JOKER, Suit.SPADES);

    public static int compare(@NotNull DataCardB card, @NotNull DataCardB anotherCard) {
        return card.compareToAny(anotherCard);
    }

    public DataCardB(Rank rank, Suit suit) {
        super(rank, suit);
    }

    public final boolean inStandardDeck() {
        boolean rankCondition = rank.getValue() >= 2 && rank.getValue() <= 13;
        return rankCondition || equals(redJoker) || equals(blackJoker);
    }

    // не понял какие правила сравнения "обычных" карт с джокерами
    // и сравнения джокеров между собой
    public final boolean compareToOther(@NotNull DataCardB card) {
        if (suit != card.suit) {
            System.out.println("Can't compare cards with different suits. Use compareToAny(DataCardB card)");
            return false;
        }
        return rank.getValue() > card.rank.getValue();
    }

    public final int compareToAny(@NotNull DataCardB card) {
        if (suit.getValue() < card.suit.getValue()) {
            return -1;
        } else if (suit.getValue() > card.suit.getValue()) {
            return 1;
        }

        if (rank.getValue() < card.rank.getValue()) {
            return -1;
        } else if (rank.getValue() > card.rank.getValue()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        String capitalizedSuit = suit.name().charAt(0) +
                suit.name().substring(1).toLowerCase();
        return String.format("%s of %s", rank.getName(), capitalizedSuit);
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        DataCardB card = (DataCardB) obj;
        return this.rank == card.rank && this.suit == card.suit;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + rank.getValue();
        result = 31 * result + suit.getValue();
        return result;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        DataCardB card = (DataCardB) o;
        return compareToAny(card);
    }
}
