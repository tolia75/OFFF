package com.example.offf.domain.usecases;

import com.example.offf.domain.model.TypeDeCours;
import com.example.offf.domain.port.primary.GestionCours;
import com.example.offf.domain.model.Cour;
import com.example.offf.domain.port.secondary.CourRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CoursManagementTest {

    private CoursManagement coursManagement;
    private CourRepository courRepository;

    @BeforeEach
    void setUp() {
        courRepository = new CourRepositoryStub();
        coursManagement = new GestionCours(courRepository);
    }

    @Test
    void doitCreerUnCours() {
        // Given
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Cour courTest = new Cour.CourBuilder()
                .typeDeCours(TypeDeCours.YOGA)
                .dateDuCours(simpleDateFormat)
                .build();

        Cour courAttendu = new Cour.CourBuilder()
                .id(1)
                .typeDeCours(TypeDeCours.YOGA)
                .dateDuCours(simpleDateFormat)
                .build();

        // When
        Cour cour = coursManagement.creerCour(courTest);

        // Assert
        assertEquals(courAttendu, cour);
    }
    
}
