package com.biblioteket.webservice.fil.repository;

import static java.lang.String.format;

import com.biblioteket.webservice.fil.model.Fil;
import com.biblioteket.webservice.fil.model.FilImpl;
import com.biblioteket.webservice.fil.model.FilInfo;
import com.biblioteket.webservice.fil.model.FilInfoImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class FilsystemRepository implements FilRepository {

  @Override
  public List<FilInfo> getFilerPaSokvag(String sokvag) throws IOException {
    return Files.list(Paths.get(sokvag))
        .map(path -> new FilInfoImpl(path.toFile()))
        .collect(Collectors.toList());
  }

  @Override
  public Fil getFilPaSokvag(String folder, String filnamn) throws IOException {
    return new FilImpl(Files.list(Paths.get(folder))
        .filter(path -> path.getFileName().toString().startsWith(filnamn))
        .findFirst()
        .orElseThrow(() -> new FileNotFoundException(format("Filen %s kunde inte hittas", filnamn)))
        .toFile());
  }

}
