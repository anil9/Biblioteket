package com.biblioteket.webservice.fil.controller;

import static java.lang.String.format;

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
    public List<FilInfo> listaFiler() throws IOException {
        try {
            return filService.listaFiler();
        } catch (IOException e) {
            logger.error("Misslyckades med att lista filer. Internal server error kastas", e);
            throw e;
        }
    }

    @GetMapping("rest/filsystem/fil/{filnamn}")
    public Fil getFil(@PathVariable @NotNull String filnamn) throws IOException {
        try {
            return filService.getFil(filnamn);
        } catch (FileNotFoundException e) {
            logger.debug(format("Fil med namn '%s' kunde inte hittas", filnamn), e);
            throw e;
        } catch (IOException e) {
            logger.error("Problem att hämta fil med namn %s. Internal server error kastas.", e);
            throw e;
        }
    }


}
