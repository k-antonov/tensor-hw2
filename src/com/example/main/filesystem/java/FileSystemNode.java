package com.example.main.filesystem;

public interface FileSystemNode {
    FileSystemNode getParent();
    String getName();
    String getPath();
}
