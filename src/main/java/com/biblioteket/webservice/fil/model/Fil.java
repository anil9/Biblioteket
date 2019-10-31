package com.biblioteket.webservice.fil.model;

import java.nio.file.Path;

public interface Fil {
    long getSize();

    String getName();

    Path getPath();
}
