package com.biblioteket.webservice.fil.controller;

import com.biblioteket.webservice.fil.model.Fil;
import com.biblioteket.webservice.fil.repository.FilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FilController {
    private final FilRepository filRepository;

    @Autowired
    public FilController(FilRepository filRepository) {
        this.filRepository = filRepository;
    }

    @GetMapping("rest/filsystem/lista")
    public ResponseEntity<List<Fil>> getListOfFiles() {
        try {
            return ResponseEntity.ok(filRepository.getListOfFiles());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
