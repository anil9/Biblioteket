package com.biblioteket.webservice.fil.model;

import java.io.File;
import java.nio.file.Path;

public class FilImpl implements Fil {
    private final File file;

    public FilImpl(File file) {
        this.file = file;
    }

    @Override
    public long getSize() {
        return file.length();
    }

    @Override
    public String getName() {
        return file.getName();
    }

    @Override
    public Path getPath() {
        return file.toPath();
    }
}
