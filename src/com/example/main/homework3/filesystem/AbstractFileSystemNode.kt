package com.example.main.homework3.filesystem

//abstract class AbstractFileSystemNode1 : FileSystemNode {
//    final override var parent: FileSystemNode? = null
//    final override var name: String?
//    final override var path: String
//        get() {
//            val parentPath = parent?.path ?: ""
//            val pathSplit = field.split("/")
//            val childPath = if (pathSplit.isNotEmpty()) {
//                "/${pathSplit[pathSplit.lastIndex]}"
//            } else ""
//            return "$parentPath$childPath"
//        }
//
//    constructor(name: String, path: String) {
//        this.name = name
//        this.path = path
//    }
//
//    constructor(
//        parent: FileSystemNode, name: String, path: String
//    ) : this(name, path) {
//        this.parent = parent
//    }
//}

abstract class AbstractFileSystemNode(
    protected val _name: String,
    protected val _path: String
) : FileSystemNode {

    // public, но как иначе изменить родителя элементов nodes в конструкторе Folder?
    // protected не даёт доступ к другим экземплярам дочернего класса, только к
    // самому себе, т. е. this
    var _parent: FileSystemNode? = null

    constructor(
        parent: FileSystemNode?,
        name: String,
        path: String
    ) : this(name, path) {
        _parent = parent
    }

    final override fun getParent() = _parent
    override fun getName() = _name

    final override fun getPath(): String {
        val parentPath = _parent?.getPath() ?: ""
        val pathSplit = _path.split("/")
        val childPath = if (pathSplit[0] != "") {
            "/${pathSplit[pathSplit.lastIndex]}"
        } else ""
        return "$parentPath$childPath"
    }

    override fun toString() = getPath()
}