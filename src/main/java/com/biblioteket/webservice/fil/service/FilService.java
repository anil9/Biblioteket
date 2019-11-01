package com.biblioteket.webservice.fil.service;

import com.biblioteket.webservice.fil.model.Fil;

import java.io.IOException;
import java.util.List;

public interface FilService {

    List<Fil> getListOfFiles() throws IOException;
}
