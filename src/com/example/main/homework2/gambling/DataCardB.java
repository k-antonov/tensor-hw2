package com.example.main.homework2.gambling;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class DataCardB extends CardB implements Comparable {
    private static final Map<Integer, String> RANK_NAMES = new HashMap<>();

    static {
        for (int i = 2; i <= 9; i++) {
            RANK_NAMES.compute(i, (key, value) ->  String.valueOf(key));
        }
        RANK_NAMES.put(10, "Jack");
        RANK_NAMES.put(11, "Queen");
        RANK_NAMES.put(12, "King");
        RANK_NAMES.put(13, "Ace");
    }

    private static final Map<Integer, String> SUIT_NAMES = Map.of(
            DIAMONDS, "Diamonds",
            CLUBS, "Clubs",
            HEARTS, "Hearts",
            SPADES, "Spades"
    );
    public static final DataCardB redJoker = new DataCardB(14, HEARTS);
    public static final DataCardB blackJoker = new DataCardB(14, SPADES);

    public static Map<Integer, String> getRankNames() {
        return RANK_NAMES;
    }

    public static Map<Integer, String> getSuitNames() {
        return SUIT_NAMES;
    }

    public static int compare(@NotNull DataCardB card, @NotNull DataCardB anotherCard) {
        return card.compareToAny(anotherCard);
    }

    public DataCardB(int rank, int suit) {
        super(rank, suit);
    }

    public final boolean inStandardDeck() {
        boolean rankCondition = rank >= 2 && rank <= 13;
        boolean suitCondition = KNOWN_SUITS.contains(suit);
        return (rankCondition && suitCondition) || equals(redJoker) || equals(blackJoker);
    }

    // не понял какие правила сравнения "обычных" карт с джокерами
    // и сравнения джокеров между собой
    public final boolean compareToOther(@NotNull DataCardB card) {
        if (suit != card.suit) {
            System.out.println("Can't compare cards with different suits. Use compareToAny(DataCardB card)");
            return false;
        }
        return rank > card.rank;
    }

    public final int compareToAny(@NotNull DataCardB card) {
        Map<Integer, Integer> suitsToValue = Map.of(
                CLUBS, 0,
                DIAMONDS, 1,
                SPADES, 2,
                HEARTS, 3
        );
        if (suitsToValue.get(suit) < suitsToValue.get(card.suit)) {
            return -1;
        } else if (suitsToValue.get(suit) > suitsToValue.get(card.suit)) {
            return 1;
        }

        if (rank < card.rank) {
            return -1;
        } else if (rank > card.rank) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        if (this.equals(blackJoker)) {
            return "Black Joker";
        } else if (this.equals(redJoker)) {
            return "Red Joker";
        } else {
            return String.format("%s of %s", RANK_NAMES.getOrDefault(rank, String.valueOf(rank)), SUIT_NAMES.get(suit));
        }
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
        result = 31 * result + rank;
        result = 31 * result + suit;
        return result;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        DataCardB card = (DataCardB) o;
        return compareToAny(card);
    }
}
