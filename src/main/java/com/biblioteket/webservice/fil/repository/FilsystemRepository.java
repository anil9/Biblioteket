package com.biblioteket.webservice.fil.repository;

import com.biblioteket.start.Hjalpklass;
import com.biblioteket.webservice.fil.model.Fil;
import com.biblioteket.webservice.fil.model.FilImpl;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FilsystemRepository implements FilRepository {
    @Override
    public List<Fil> getListOfFiles() throws IOException {
        return Files.list(Paths.get(Hjalpklass.BAS_REPOSITORY_PATH))
                .map(path -> new FilImpl(path.toFile()))
                .collect(Collectors.toList());
    }
}
