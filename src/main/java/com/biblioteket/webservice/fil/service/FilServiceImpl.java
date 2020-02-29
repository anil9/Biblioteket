package com.biblioteket.webservice.fil.service;

import com.biblioteket.Sokvag;
import com.biblioteket.webservice.fil.model.Fil;
import com.biblioteket.webservice.fil.model.FilInfo;
import com.biblioteket.webservice.fil.repository.FilRepository;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FilServiceImpl implements FilService {
    private final FilRepository filRepository;

    public FilServiceImpl(FilRepository filRepository) {
        this.filRepository = filRepository;
    }

    @Override
    public List<FilInfo> listaFiler() throws IOException {
        return filRepository.getFilerPaSokvag(Sokvag.BAS_REPOSITORY_PATH);
    }

    @Override
    public Fil getFil(String filnamn) throws IOException {
        return filRepository.getFilPaSokvag(Sokvag.BAS_REPOSITORY_PATH, filnamn);
    }
}
