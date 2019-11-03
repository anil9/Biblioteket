package com.biblioteket.webservice.fil.controller;

import com.biblioteket.webservice.fil.model.FilImpl;
import com.biblioteket.webservice.fil.model.FilInfoImpl;
import com.biblioteket.webservice.fil.service.FilService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(FilController.class)
class FilControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    FilService filService;


    @Test
    void whenListOfFile_returnsFile() throws Exception {
        File tempFile = File.createTempFile("test", "testfile");
        tempFile.deleteOnExit();
        given(filService.getListOfFiles()).willReturn(Collections.singletonList(new FilInfoImpl(tempFile)));

        mockMvc.perform(get("/rest/filsystem/lista")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", equalTo(tempFile.getName())));
    }

    @Test
    void whenEmptyList_returnsEmpty() throws Exception {
        given(filService.getListOfFiles()).willReturn(Collections.emptyList());

        mockMvc.perform(get("/rest/filsystem/lista")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void whenListOfFilesException_returnStatus5xx() throws Exception {
        given(filService.getListOfFiles()).willThrow(IOException.class);

        mockMvc.perform(get("/rest/filsystem/lista")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }

    @Test
    void whenGetFil_returnFile() throws Exception {
        File tempFile = File.createTempFile("test", "testfile");
        tempFile.deleteOnExit();

        given(filService.getFil(tempFile.getName())).willReturn(new FilImpl(tempFile));

        mockMvc.perform(get("/rest/filsystem/" + tempFile.getName())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.info.name", equalTo(tempFile.getName())));
    }

}