package com.biblioteket.webservice.fil.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilImpl implements Fil {

    private final FilInfo filInfo;
    private final byte[] data;

    public FilImpl(File file) throws IOException {
        this.filInfo = new FilInfoImpl(file);
        this.data = Files.readAllBytes(file.toPath());
    }

    @Override
    public FilInfo getInfo() {
        return filInfo;
    }

    @Override
    public byte[] getData() {
        return data;
    }
}
