package com.example.main.homework3.filesystem

class File(_name: String, _path: String) : AbstractFileSystemNode(_name, _path) {

    fun getExtension(): String {
        val nameSplit = _name.split(".")
        return if (nameSplit.size > 1) nameSplit[1] else ""
    }
}