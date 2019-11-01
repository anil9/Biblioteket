package com.biblioteket.webservice.fil.service;

import com.biblioteket.Hjalpklass;
import com.biblioteket.webservice.fil.model.Fil;
import com.biblioteket.webservice.fil.repository.FilRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FilServiceImpl implements FilService {
    private final FilRepository filRepository;

    public FilServiceImpl(FilRepository filRepository) {
        this.filRepository = filRepository;
    }

    @Override
    public List<Fil> getListOfFiles() throws IOException {
        return filRepository.getFilerPaSokvag(Hjalpklass.BAS_REPOSITORY_PATH);
    }
}
