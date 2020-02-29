package com.biblioteket.webservice.fil.controller;

import com.biblioteket.webservice.fil.model.Fil;
import com.biblioteket.webservice.fil.model.FilInfo;
import com.biblioteket.webservice.fil.service.FilService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilController {

    private final FilService filService;
    private final Logger logger = LoggerFactory.getLogger(FilController.class);


    @Autowired
    public FilController(FilService filService) {
        this.filService = filService;
    }

    @GetMapping("rest/filsystem/lista")
    public ResponseEntity<List<FilInfo>> listaFiler() {
        try {
            return ResponseEntity.ok(filService.listaFiler());
        } catch (IOException e) {
            logger.error("Misslyckades med att lista filer. Internal server error kastas", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("rest/filsystem/fil/{filnamn}")
    public ResponseEntity<Fil> getFil(@PathVariable @NotNull String filnamn) {
        try {
            return ResponseEntity.ok(filService.getFil(filnamn));
        } catch (FileNotFoundException e) {
            logger.debug(String.format("Fil med namn '%s' kunde inte hittas", filnamn), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (IOException e) {
            logger.error("Problem att hämta fil med namn %s. Internal server error kastas.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
