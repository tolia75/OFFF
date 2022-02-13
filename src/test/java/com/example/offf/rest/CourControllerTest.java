package com.example.offf.rest;

import com.example.offf.domain.model.Cour;
import com.example.offf.domain.model.TypeDeCours;
import com.example.offf.domain.port.primary.GestionCours;
import com.example.offf.domain.port.secondary.CourAdapter;
import com.example.offf.domain.usecases.CoursManagement;
import com.example.offf.infrastructure.rest.CourController;
import com.example.offf.infrastructure.rest.dto.CourDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void doitRenvoyerBadRequestCarAbsenceDeBody() throws Exception {
        mockMvc.perform(post("/cour"))
                .andExpect(status().isBadRequest());
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
