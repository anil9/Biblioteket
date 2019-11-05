package com.biblioteket.webservice.fil.service;

import com.biblioteket.webservice.fil.model.Fil;
import com.biblioteket.webservice.fil.model.FilInfo;
import java.io.IOException;
import java.util.List;

public interface FilService {

    List<FilInfo> listaFiler() throws IOException;

    Fil getFil(String filnamn) throws IOException;
}
