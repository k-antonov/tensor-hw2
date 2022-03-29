package com.example.main.homework3.filesystem

interface FileSystemNode {
    fun getParent(): FileSystemNode?
    fun getName(): String?
    fun getPath(): String
}
