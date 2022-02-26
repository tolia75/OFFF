package com.example.offf.rest;

import com.example.offf.hexagon.infrastructure.rest.dto.SportifDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SportifControllerTest {

    // TODO - ADS - Gérer une base tampon pour les tests

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
    }

    @Test
    void doitRenvoyerBadRequestCarAbsenceDeBody() throws Exception {
        mockMvc.perform(post("/sportif"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void doitRenvoyerBadRequestCarPasDePrenom() throws Exception {
        mockMvc.perform(post("/sportif")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(
                        new SportifDto.SportifDtoBuilder()
                                .nom("nom")
                                .build())))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void doitRenvoyerBadRequestCarPasDeNom() throws Exception {
        mockMvc.perform(post("/sportif")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(
                        new SportifDto.SportifDtoBuilder()
                                .prenom("prenom")
                                .build())))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void doitRenvoyerNouveauSportif() throws Exception {
        mockMvc.perform(post("/sportif")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(
                        new SportifDto.SportifDtoBuilder()
                                .nom("nom")
                                .prenom("prenom")
                                .build())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(4)))
                .andExpect(jsonPath("nom", is("nom")))
                .andExpect(jsonPath("prenom", is("prenom")));
    }
}
