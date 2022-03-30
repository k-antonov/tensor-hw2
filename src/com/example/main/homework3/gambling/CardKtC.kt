package com.example.main.homework3.gambling

import kotlin.math.max

class CardKtC(rank: Rank, suit: Suit) : CardKtB(rank, suit) {
    companion object {
        val MAX_RANKS = mutableMapOf<Suit, Int>()
    }

    init {
        MAX_RANKS.compute(suit) { _, maxKnown ->
            if (maxKnown == null) rank.value else max(maxKnown, rank.value)
        }
    }

    constructor(suit: Suit) : this(
        Rank.fromValue(MAX_RANKS.getOrDefault(suit, 0) + 1), suit
    )
}