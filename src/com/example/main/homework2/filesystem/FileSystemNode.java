package com.example.main.homework2.filesystem;

public interface FileSystemNode {
    FileSystemNode getParent();
    String getName();
    String getPath();
}
