package com.example.main.filesystem;

public class File extends AbstractFileSystemNode {
    public File(String name, String path) {
        super(name, path);
    }

    public String getExtension() {
        String[] nameSplit = name.split("\\.");
        return (nameSplit.length > 1) ? nameSplit[1] : null;
    }
}
