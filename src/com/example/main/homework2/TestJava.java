package com.example.main.homework2;

import com.example.main.homework2.filesystem.File;
import com.example.main.homework2.filesystem.Folder;
import com.example.main.homework2.gambling.*;

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
            deck52.returnCard(new DataCardB(Rank.ACE, Suit.HEARTS));
            deck52.returnCard(new DataCardB(Rank.KING, Suit.HEARTS));
            deck52.returnCard(new DataCardB(Rank.QUEEN, Suit.HEARTS));
            deck52.returnCard(new DataCardB(Rank.QUEEN, Suit.HEARTS));
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
        CardC fourOfDiamonds = new CardC(Rank.FOUR, Suit.DIAMONDS);
        CardC sixOfClubs = new CardC(Rank.SIX, Suit.CLUBS);
        CardC shouldBeFiveOfDiamonds = new CardC(Suit.DIAMONDS);
        System.out.println(shouldBeFiveOfDiamonds.getRank());
    }

    public static void thirdTask() {
        DataCardB eightOfHearts = new DataCardB(Rank.EIGHT, Suit.HEARTS);
        DataCardB anotherEightOfHearts = new DataCardB(Rank.EIGHT, Suit.HEARTS);
        DataCardB aceOfSpades = new DataCardB(Rank.ACE, Suit.SPADES);
        System.out.println(eightOfHearts.equals(anotherEightOfHearts));
        System.out.println(aceOfSpades);

        // невозможно создать карту не из стандартной колоды,
        // в перечислениях объявлены все возможные варианты
//        DataCardB wrongCard = new DataCardB(Rank.ONE, Suit.DIAMONDS);
        DataCardB blackJoker = new DataCardB(Rank.JOKER, Suit.SPADES);

        // поэтому функция больше не имеет смысла
        for (DataCardB card : new DataCardB[]{eightOfHearts, aceOfSpades, blackJoker}) {
            System.out.println(card + " in standard deck? " + card.inStandardDeck());
        }

        System.out.println(eightOfHearts + " stronger than " + aceOfSpades
                + "? " + eightOfHearts.compareToOther(aceOfSpades));

        DataCardB sevenOfSpades = new DataCardB(Rank.SEVEN, Suit.SPADES);
        DataCardB sevenOfHearts = new DataCardB(Rank.SEVEN, Suit.HEARTS);
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
