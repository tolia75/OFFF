package com.example.offf.rest;

import com.example.offf.hexagon.domain.model.TypeDeCours;
import com.example.offf.hexagon.infrastructure.rest.dto.CourDto;
import com.example.offf.hexagon.infrastructure.rest.dto.SportifDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "classpath:schema-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class CourControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = JsonMapper.builder()
        .findAndAddModules()
        .build();

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
                .andExpect(jsonPath("id", is(4)))
                .andExpect(jsonPath("typeDeCour", is("YOGA")))
                .andExpect(jsonPath("dateDuCour", is("01/01/2022 01:01:00")));

    }

    @Test
    void doitRenvoyerTousLesCours() throws Exception {
        mockMvc.perform(get("/cour/cours"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].typeDeCour", is("HIIT")))
                .andExpect(jsonPath("$[0].dateDuCour", is("14/02/2022 00:00:00")))
                .andExpect(jsonPath("$[0].sportifsDtos[0].id", is(1)))
                .andExpect(jsonPath("$[0].sportifsDtos[0].nom", is("nom")))
                .andExpect(jsonPath("$[0].sportifsDtos[0].prenom", is("prenom")))


                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].typeDeCour", is("YOGA")))
                .andExpect(jsonPath("$[1].dateDuCour", is("14/02/2022 00:00:00")))

                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].typeDeCour", is("PILATE")))
                .andExpect(jsonPath("$[2].dateDuCour", is("14/02/2022 00:00:00")));
    }

    @Test
    void doitAjouterSportifToCour() throws Exception {
        long sportifId = 1;
        SportifDto sportif= new SportifDto.SportifDtoBuilder()
                .id(sportifId)
                .nom("nom")
                .prenom("prenom")
                .build();

        long courId = 1;
        CourDto expectedCour = new CourDto.CourDtoBuilder()
                .id(courId)
                .typeDeCour(TypeDeCours.YOGA)
                .dateDuCour(LocalDateTime.of(2022, 1, 1, 20, 20))
                .sportifDto(Set.of(sportif))
                .build();

        mockMvc.perform(post("/cour/sportif")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(expectedCour)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("typeDeCour", is("YOGA")))
                .andExpect(jsonPath("dateDuCour", is("01/01/2022 20:20:00")))
                .andExpect(jsonPath("sportifsDtos[0].id", is(1)))
                .andExpect(jsonPath("sportifsDtos[0].nom", is("nom")))
                .andExpect(jsonPath("sportifsDtos[0].prenom", is("prenom")));
    }
}
