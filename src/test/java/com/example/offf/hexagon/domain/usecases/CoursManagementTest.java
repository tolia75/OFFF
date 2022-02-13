package com.example.offf.hexagon.domain.usecases;

import com.example.offf.hexagon.domain.exception.ObjetMetierNonValideException;
import com.example.offf.hexagon.domain.model.TypeDeCours;
import com.example.offf.hexagon.domain.port.primary.GestionCours;
import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.port.secondary.CourAdapter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoursManagementTest {

    private CoursManagement coursManagement;
    private CourAdapter courAdapter;

    @BeforeEach
    void setUp() {
        courAdapter = new CourAdapterStub();
        coursManagement = new GestionCours(courAdapter);
    }

    @Test
    void doitCreerUnCoursModeYoga() {
        // Given
        LocalDateTime localDateTime = LocalDateTime.of(2022, 1, 1, 1, 1);
        Cour courTest = createCourTest(TypeDeCours.YOGA, localDateTime);
        Cour courAttendu = createCourAttendu(1, TypeDeCours.YOGA, localDateTime);

        // When
        Cour cour = coursManagement.creerCour(courTest);

        // Assert
        assertEquals(courAttendu, cour);
    }

    @Test
    void doitCreerUnCoursModeHIIT() {
        // Given
        LocalDateTime localDateTime = LocalDateTime.of(2022, 1, 1, 1, 1);
        Cour courTest = createCourTest(TypeDeCours.HIIT, localDateTime);
        Cour courAttendu = createCourAttendu(1, TypeDeCours.HIIT, localDateTime);

        // When
        Cour cour = coursManagement.creerCour(courTest);

        // Assert
        assertEquals(courAttendu, cour);
    }

    @Test
    void doitCreerUnCoursModeZumba() {
        // Given
        LocalDateTime localDateTime = LocalDateTime.of(2022, 1, 1, 1, 1);
        Cour courTest = createCourTest(TypeDeCours.ZUMBA, localDateTime);
        Cour courAttendu = createCourAttendu(1, TypeDeCours.ZUMBA, localDateTime);

        // When
        Cour cour = coursManagement.creerCour(courTest);

        // Assert
        assertEquals(courAttendu, cour);
    }

    @Test
    void doitCreerUnCoursModePilate() {
        // Given
        LocalDateTime localDateTime = LocalDateTime.of(2022, 1, 1, 1, 1);
        Cour courTest = createCourTest(TypeDeCours.PILATE, localDateTime);
        Cour courAttendu = createCourAttendu(1, TypeDeCours.PILATE, localDateTime);

        // When
        Cour cour = coursManagement.creerCour(courTest);

        // Assert
        assertEquals(courAttendu, cour);
    }

    @Test
    void neDoitPasCreerUnCoursSiPasDeTypeDeCours() {
        // Given
        LocalDateTime localDateTime = LocalDateTime.of(2022, 1, 1, 1, 1);
        Cour courTest = new Cour.CourBuilder()
                .dateDuCours(localDateTime)
                .build();

        Assertions.assertThatThrownBy(() -> coursManagement.creerCour(courTest))
                .isInstanceOf(ObjetMetierNonValideException.class)
                .hasMessageContaining("Le cours transmis n'est pas correcte");
    }

    @Test
    void neDoitPasCreerUnCoursSiPasDeDate() {
        // Given
        Cour courTest = new Cour.CourBuilder()
                .typeDeCours(TypeDeCours.YOGA)
                .build();

        Assertions.assertThatThrownBy(() -> coursManagement.creerCour(courTest))
                .isInstanceOf(ObjetMetierNonValideException.class)
                .hasMessageContaining("Le cours transmis n'est pas correcte");
    }

    private Cour createCourAttendu(long id, TypeDeCours typeDeCours, LocalDateTime localDateTime) {
        return new Cour.CourBuilder()
                .id(1)
                .typeDeCours(typeDeCours)
                .dateDuCours(localDateTime)
                .build();
    }

    private Cour createCourTest(TypeDeCours typeDeCours,  LocalDateTime localDateTime) {
        return new Cour.CourBuilder()
                .typeDeCours(typeDeCours)
                .dateDuCours(localDateTime)
                .build();
    }
}
