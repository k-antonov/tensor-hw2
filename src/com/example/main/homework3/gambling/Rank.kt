package com.example.main.homework3.gambling

import java.lang.IllegalArgumentException

enum class Rank(val value: Int) {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    JACK(10),
    QUEEN(11),
    KING(12),
    ACE(13),
    JOKER(14);

    companion object {
        fun fromValue(value: Int) : Rank {
            for (rank in values()) {
                if (value == rank.value) {
                    return rank
                }
            }
            throw IllegalArgumentException("No rank with value $value found")
        }
    }
}