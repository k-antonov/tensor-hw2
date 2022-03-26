package com.example.main;

public class Main {
    public static void main(String[] args){
        CardC cardCFirst = new CardC(4, 0);
        CardC cardCSecond = new CardC(6, 0);
        CardC cardCThird = new CardC(0);
        System.out.println(cardCThird.getRank());
    }
}
