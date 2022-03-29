package com.example.main.homework2;

import com.example.main.homework2.filesystem.File;
import com.example.main.homework2.filesystem.Folder;
import com.example.main.homework2.gambling.Card;
import com.example.main.homework2.gambling.CardC;
import com.example.main.homework2.gambling.DataCardB;
import com.example.main.homework2.gambling.Deck;

public class TestJava {
    public static void fifthTask() {
        Folder root = new Folder(null, null, "/");
        Folder home = new Folder(root, "home", "./home");
        Folder memes = new Folder(home, "memes", "./memes",
                new File("jackals.jpg", "./jackals.jpg"),
                new File("khasbik.jpg", "./khasbik.jpg"),
                new File("pixar_mom.png", "./pixar_mom.png"),
                new File(null, ""));
        System.out.println(memes.getChildNodes());
        File file = (File) memes.getChildNodes().get(2);
        System.out.println(file.getPath());
        System.out.println(file.getExtension());
    }

    public static void fourthTask() {
        Deck deck52 = Deck.buildDeck();
        for (int i = 0; i < 5; i++) {
            System.out.println("Dealt " + deck52.dealCard());
        }
        try {
            deck52.returnCard(new DataCardB(13, Card.HEARTS));
            deck52.returnCard(new DataCardB(12, Card.HEARTS));
            deck52.returnCard(new DataCardB(11, Card.HEARTS));
            deck52.returnCard(new DataCardB(11, Card.HEARTS));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(deck52);
        deck52.shuffle();
        System.out.println(deck52);
        deck52.sort();
        System.out.println(deck52);

        while (!deck52.isEmpty()) {
            deck52.dealCard();
        }
        System.out.println(deck52);
    }

    public static void secondTask() {
        CardC cardCFirst = new CardC(4, Card.DIAMONDS);
        CardC cardCSecond = new CardC(6, Card.CLUBS);
        CardC cardCThird = new CardC(Card.DIAMONDS);
        System.out.println(cardCThird.getRank());
    }

    public static void thirdTask() {
        DataCardB eightOfHearts = new DataCardB(8, Card.HEARTS);
        DataCardB anotherEightOfHearts = new DataCardB(8, Card.HEARTS);
        DataCardB aceOfSpades = new DataCardB(13, Card.SPADES);
        System.out.println(eightOfHearts.equals(anotherEightOfHearts));
        System.out.println(aceOfSpades);

        DataCardB wrongCard = new DataCardB(1, Card.DIAMONDS);
        DataCardB joker = new DataCardB(14, Card.SPADES);
        for (DataCardB card : new DataCardB[]{eightOfHearts, aceOfSpades, wrongCard, joker}) {
            System.out.println(card + " in standard deck? " + card.inStandardDeck());
        }
        System.out.println(eightOfHearts + " stronger than " + aceOfSpades
                + "? " + eightOfHearts.compareToOther(aceOfSpades));

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
