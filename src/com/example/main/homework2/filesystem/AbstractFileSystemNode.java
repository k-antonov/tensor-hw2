package com.example.main.homework2.filesystem;

public abstract class AbstractFileSystemNode implements FileSystemNode {
    protected FileSystemNode parent;
    protected final String name;
    protected final String path;

    protected AbstractFileSystemNode(FileSystemNode parent, String name, String path) {
        this.parent = parent;
        this.name = name;
        this.path = path;
    }

    protected AbstractFileSystemNode(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public final FileSystemNode getParent() {
        return parent;
    }

    @Override
    public String getName() {
        return name;
    }

    // full path
    @Override
    public final String getPath() {
        String parentPath;
        if (parent != null) {
            parentPath = parent.getPath();
        } else {
            parentPath = "";
        }
        String[] pathSplit = path.split("/");
        String childPath;
        if (pathSplit.length > 0) {
            childPath = "/" + pathSplit[pathSplit.length - 1];
        } else {
            childPath = "";
        }
        return parentPath + childPath;
    }

    @Override
    public String toString() {
        return getPath();
    }
}
