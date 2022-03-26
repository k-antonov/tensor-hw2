package com.example.main;

// не наследуюсь от CardA, потому что нельзя public поле переопределить в private.
public class CardB implements Card {
    private int rank;
    private int suit;

    public CardB(int rank, int suit) {
        this.rank = rank;
        setSuit(suit);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        if (checkSuit(suit)) {
            this.suit = suit;
        } else {
            System.out.println("Setting suit to " + DIAMONDS);
            this.suit = DIAMONDS;
        }
    }

    // хотелось бы использовать Enum, но в задании написано проверять значение suit и в случае
    // ошибки выводить соответствующее значение. При использовании Enum проверка не имела бы
    // смысла, т. к. нельзя было бы передать некорректное значение в setSuit(Suit suit)
    private boolean checkSuit(int suit) {
        int[] allSuits = {DIAMONDS, CLUBS, HEARTS, SPADES};
        for (int s : allSuits) {
            if (suit == s) {
                return true;
            }
        }
        System.err.println("Invalid suit value");
        return false;
    }
}
