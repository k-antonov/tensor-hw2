package com.example.main;

public class Main {
    public static void main(String[] args){
        // 2.
        CardC cardCFirst = new CardC(4, Card.DIAMONDS);
        CardC cardCSecond = new CardC(6, Card.CLUBS);
        CardC cardCThird = new CardC(Card.DIAMONDS);
        System.out.println(cardCThird.getRank());
        System.out.println();

        // 3.
        DataCardB eightOfHearts = new DataCardB(8, Card.HEARTS);
        DataCardB anotherEightOfHearts = new DataCardB(8, Card.HEARTS);
        DataCardB aceOfSpades = new DataCardB(13, Card.SPADES);
        System.out.println(eightOfHearts.equals(anotherEightOfHearts));
        System.out.println(aceOfSpades);

        DataCardB wrongCard = new DataCardB(1, Card.DIAMONDS);
        DataCardB joker = new DataCardB(14, Card.SPADES);
        for(DataCardB card : new DataCardB[]{eightOfHearts, aceOfSpades, wrongCard, joker}) {
            System.out.println(card + " in standard deck? " + card.inStandardDeck());
        }
        System.out.println(eightOfHearts + " stronger than " + aceOfSpades
                + "? " + eightOfHearts.compareTo(aceOfSpades));

        DataCardB sevenOfSpades = new DataCardB(7, Card.SPADES);
        DataCardB sevenOfHearts = new DataCardB(7, Card.HEARTS);
        System.out.println(sevenOfSpades + " stronger than " + aceOfSpades
                + "? " + sevenOfSpades.compareToAny(aceOfSpades));
        System.out.println(sevenOfHearts + " stronger than " + sevenOfSpades
                + "? " + sevenOfHearts.compareToAny(sevenOfSpades));
        System.out.println(eightOfHearts + " stronger than " + anotherEightOfHearts
                + "? " + eightOfHearts.compareToAny(anotherEightOfHearts));

        System.out.println();
        System.out.println(DataCardB.compare(sevenOfSpades, aceOfSpades));
        System.out.println(DataCardB.compare(sevenOfHearts, sevenOfSpades));
        System.out.println(DataCardB.compare(eightOfHearts, anotherEightOfHearts));
    }
}
