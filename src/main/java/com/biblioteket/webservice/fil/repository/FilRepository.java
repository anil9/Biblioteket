package com.biblioteket.webservice.fil.repository;

import com.biblioteket.webservice.fil.model.Fil;
import com.biblioteket.webservice.fil.model.FilInfo;

import java.io.IOException;
import java.util.List;

public interface FilRepository {
    List<FilInfo> listFiles() throws IOException;

    Fil getFil(String filnamn) throws IOException;
}
