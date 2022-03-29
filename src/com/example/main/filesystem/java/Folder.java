package com.example.main.filesystem;

import java.util.ArrayList;

public class Folder extends AbstractFileSystemNode {
    private final ArrayList<AbstractFileSystemNode> childNodes = new ArrayList<>();

    // не понял почему конструктор должен принимать переменное
    // число аргументов типа FileSystemNode, а не
    // AbstractFileSystemNode, ведь у самого FileSystemNode
    // нет родительского элемента, он не может быть изменён, т. к.
    // поля, определяемые в интерфейсах, являются public static final
    public Folder(
            FileSystemNode parent,
            String name,
            String path,
            AbstractFileSystemNode... nodes
    ) {
        super(parent, name, path);
        for (AbstractFileSystemNode node: nodes) {
            node.parent = this;
            childNodes.add(node);
        }
    }

    public ArrayList<AbstractFileSystemNode> getChildNodes() {
        return childNodes;
    }
}
