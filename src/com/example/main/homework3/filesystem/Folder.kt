package com.example.main.homework3.filesystem

class Folder(
    parent: FileSystemNode?,
    name: String,
    path: String,
    vararg nodes: AbstractFileSystemNode
) : AbstractFileSystemNode(parent, name, path) {

    private val childNodes = ArrayList<AbstractFileSystemNode>()

    init {
        for (node in nodes) {
            node._parent = this
            childNodes.add(node)
        }
    }

    fun getChildNodes() = childNodes
}