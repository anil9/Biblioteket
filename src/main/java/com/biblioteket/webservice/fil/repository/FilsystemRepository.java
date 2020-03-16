package com.biblioteket.webservice.fil.repository;

import com.biblioteket.webservice.fil.model.Fil;
import com.biblioteket.webservice.fil.model.FilImpl;
import com.biblioteket.webservice.fil.model.FilInfo;
import com.biblioteket.webservice.fil.model.FilInfoImpl;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Repository
public class FilsystemRepository implements FilRepository {
    private static final String BAS_PATH = "D:\\downloads";

    @Override
    public List<FilInfo> listFiles() throws IOException {
        return Files.list(Paths.get(BAS_PATH))
                .map(path -> new FilInfoImpl(path.toFile()))
                .collect(Collectors.toList());
    }

    @Override
    public Fil getFil(String filnamn) throws IOException {
        return new FilImpl(Files.list(Paths.get(BAS_PATH))
                .filter(path -> path.getFileName()
                        .toString()
                        .startsWith(filnamn))
                .findFirst()
                .orElseThrow(() -> new FileNotFoundException(format("Filen %s kunde inte hittas", filnamn)))
                .toFile());
    }

}
