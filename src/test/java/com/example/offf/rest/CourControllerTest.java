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

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CourControllerTest {

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
                                .dateDuCours("13/02/2022")
                                .build())))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void doitRenvoyerBadRequestCarPasDeDateDuCour() throws Exception {
        mockMvc.perform(post("/cour")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(
                        new CourDto.CourDtoBuilder()
                                .typeDeCours(TypeDeCours.YOGA)
                                .build())))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void doitRenvoyerNouveauCour() throws Exception {
        mockMvc.perform(post("/cour")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(
                        new CourDto.CourDtoBuilder()
                        .typeDeCours(TypeDeCours.YOGA)
                        .dateDuCours("13/02/2022")
                        .build())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is("1")))
                .andExpect(jsonPath("$[0].typeDuCour", is("YOGA")))
                .andExpect(jsonPath("$[0].dateDuCour", is("1")));
    }
}
