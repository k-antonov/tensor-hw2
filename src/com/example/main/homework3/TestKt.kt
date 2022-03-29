package com.example.main.homework3

import com.example.main.homework3.filesystem.File
import com.example.main.homework3.filesystem.Folder

class TestKt {
    companion object {
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