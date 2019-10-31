package com.biblioteket.webservice.fil.repository;

import com.biblioteket.webservice.fil.model.Fil;

import java.io.IOException;
import java.util.List;

public interface FilRepository {
    List<Fil> getListOfFiles() throws IOException;
}
