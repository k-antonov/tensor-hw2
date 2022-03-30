package com.example.main.homework3.gambling

data class DataCardBKt(override val rank: Rank, override val suit: Suit) : CardKtB(rank, suit) {
    companion object {
        private val redJoker = DataCardBKt(Rank.JOKER, Suit.HEARTS)
        private val blackJoker = DataCardBKt(Rank.JOKER, Suit.SPADES)

        fun buildJoker(isRed: Boolean) : DataCardBKt{
            return if (isRed) redJoker else blackJoker
        }
    }

    fun inStandardDeck(): Boolean {
        return rank in Rank.values() || equals(redJoker) || equals(blackJoker)
    }

    fun compareToOther(card: DataCardBKt): Boolean {
        if (suit != card.suit) {
            println("Can't compare cards with different suits. Use compareToAny(card: DataCardBKt)")
            return false
        }
        return rank.value > card.rank.value
    }

    fun compareToAny(card: DataCardBKt) : Int {
        when {
            suit.value < card.suit.value -> return -1
            suit.value > card.suit.value -> return 1
        }
        return when {
            rank.value < card.rank.value -> -1
            rank.value > card.rank.value -> 1
            else -> 0
        }
    }

    override fun toString() = when (this) {
        redJoker -> "DataCardBKt(Red Joker)"
        blackJoker -> "DataCardBKt(Black Joker)"
        else -> "DataCardBKt(${rank.name.lowercase().replaceFirstChar { it.uppercase() }}" +
                " of ${suit.name.lowercase().replaceFirstChar { it.uppercase() }})"
    }
}
