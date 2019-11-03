package com.biblioteket.webservice.fil.model;

import java.io.File;
import java.nio.file.Path;

public class FilInfoImpl implements FilInfo {
    private final File file;

    public FilInfoImpl(File file) {
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
