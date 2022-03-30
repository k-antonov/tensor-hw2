package com.example.main.homework3

import com.example.main.homework3.filesystem.File
import com.example.main.homework3.filesystem.Folder
import com.example.main.homework3.gambling.CardKtC
import com.example.main.homework3.gambling.DataCardBKt
import com.example.main.homework3.gambling.Rank
import com.example.main.homework3.gambling.Suit

class TestKt {
    companion object {
        @JvmStatic
        fun secondTask() {
            val fourOfDiamonds = CardKtC(Rank.FOUR, Suit.DIAMONDS)
            val shouldBeFiveOfDiamonds = CardKtC(Suit.DIAMONDS)
            println(shouldBeFiveOfDiamonds.rank)

            val fiveOfClubs = DataCardBKt(Rank.FIVE, Suit.CLUBS)
            val anotherFiveOfClubs = DataCardBKt(Rank.FIVE, Suit.CLUBS)
            val kingOfDiamonds = DataCardBKt(Rank.KING, Suit.DIAMONDS)
            println(kingOfDiamonds)
            println(fiveOfClubs == anotherFiveOfClubs)

            // всё еще возможно создать некорректного джокера третьего типа,
            // пока не могу придумать решение проблемы
            val redJoker = DataCardBKt.buildJoker(isRed = true)
            println(redJoker)
            println(fiveOfClubs.compareToOther(kingOfDiamonds))
            println(fiveOfClubs.compareToAny(kingOfDiamonds))
        }

        @JvmStatic
        fun thirdTask() {
            val root = Folder(null, "", "/")
            val home = Folder(root, "home", "./home")
            val memes = Folder(
                home, "memes", "./memes",
                File("jackals.jpg", "./jackals.jpg"),
                File("khasbik.jpg", "./khasbik.jpg"),
                File("pixar_mom.jpg", "./pixar_mom.jpg")
            )

            println(memes.getChildNodes())
            val file = memes.getChildNodes()[2] as File
            println(file.getPath())
            println("Extension of $file is ${file.getExtension()}")
        }
    }
}