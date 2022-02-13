package com.example.offf.rest;

import com.example.offf.hexagon.domain.model.TypeDeCours;
import com.example.offf.hexagon.infrastructure.rest.dto.CourDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CourControllerTest {

    // TODO - ADS - Gérer une base tampon pour les tests

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
    }

    @Test
    void doitRenvoyerBadRequestCarAbsenceDeBody() throws Exception {
        mockMvc.perform(post("/cour"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void doitRenvoyerBadRequestCarPasDeTypeDuCour() throws Exception {
        mockMvc.perform(post("/cour")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(
                        new CourDto.CourDtoBuilder()
                                .dateDuCour(LocalDateTime.of(2022, 1,1,1,1))
                                .build())))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void doitRenvoyerBadRequestCarPasDeDateDuCour() throws Exception {
        mockMvc.perform(post("/cour")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(
                        new CourDto.CourDtoBuilder()
                                .typeDeCour(TypeDeCours.YOGA)
                                .build())))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void doitRenvoyerNouveauCour() throws Exception {
        mockMvc.perform(post("/cour")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(
                        new CourDto.CourDtoBuilder()
                                .typeDeCour(TypeDeCours.YOGA)
                                .dateDuCour(LocalDateTime.of(2022, 1,1,1,1))
                                .build())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is("1")))
                .andExpect(jsonPath("$[0].typeDeCour", is("YOGA")))
                .andExpect(jsonPath("$[0].dateDuCour", is("1")));
    }

    @Test
    void doitRenvoyerTousLesCours() throws Exception {
        mockMvc.perform(get("/cour/cours"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].typeDeCour", is("YOGA")))
                .andExpect(jsonPath("$[0].dateDuCour", is("1")))

                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].typeDeCour", is("HIIT")))
                .andExpect(jsonPath("$[1].dateDuCour", is("1")))

                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].typeDeCour", is("PILATE")))
                .andExpect(jsonPath("$[2].dateDuCour", is("1")))

                .andExpect(jsonPath("$[3].id", is(4)))
                .andExpect(jsonPath("$[3].typeDeCour", is("ZUMBA")))
                .andExpect(jsonPath("$[3].dateDuCour", is("1")));
    }
}
