package com.example.offf.domain.usecases;

import com.example.offf.domain.exception.ObjetMetierNonValideException;
import com.example.offf.domain.model.TypeDeCours;
import com.example.offf.domain.port.primary.GestionCours;
import com.example.offf.domain.model.Cour;
import com.example.offf.domain.port.secondary.CourRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Optional;

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
    void doitCreerUnCoursModeYoga() {
        // Given
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Cour courTest = createCourTest(TypeDeCours.YOGA, simpleDateFormat);
        Cour courAttendu = createCourAttendu(1, TypeDeCours.YOGA, simpleDateFormat);

        // When
        Cour cour = coursManagement.creerCour(courTest);

        // Assert
        assertEquals(courAttendu, cour);
    }

    @Test
    void doitCreerUnCoursModeHIIT() {
        // Given
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Cour courTest = createCourTest(TypeDeCours.HIIT, simpleDateFormat);
        Cour courAttendu = createCourAttendu(1, TypeDeCours.HIIT, simpleDateFormat);

        // When
        Cour cour = coursManagement.creerCour(courTest);

        // Assert
        assertEquals(courAttendu, cour);
    }

    @Test
    void doitCreerUnCoursModeZumba() {
        // Given
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Cour courTest = createCourTest(TypeDeCours.ZUMBA, simpleDateFormat);
        Cour courAttendu = createCourAttendu(1, TypeDeCours.ZUMBA, simpleDateFormat);

        // When
        Cour cour = coursManagement.creerCour(courTest);

        // Assert
        assertEquals(courAttendu, cour);
    }

    @Test
    void doitCreerUnCoursModePilate() {
        // Given
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Cour courTest = createCourTest(TypeDeCours.PILATE, simpleDateFormat);
        Cour courAttendu = createCourAttendu(1, TypeDeCours.PILATE, simpleDateFormat);

        // When
        Cour cour = coursManagement.creerCour(courTest);

        // Assert
        assertEquals(courAttendu, cour);
    }

    @Test
    void neDoitPasCreerUnCoursSiPasDeTypeDeCours() {
        // Given
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Cour courTest = new Cour.CourBuilder()
                .dateDuCours(simpleDateFormat)
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

    private Cour createCourAttendu(long id, TypeDeCours typeDeCours, SimpleDateFormat simpleDateFormat) {
        return new Cour.CourBuilder()
                .id(1)
                .typeDeCours(typeDeCours)
                .dateDuCours(simpleDateFormat)
                .build();
    }

    private Cour createCourTest(TypeDeCours typeDeCours, SimpleDateFormat simpleDateFormat) {
        return new Cour.CourBuilder()
                .typeDeCours(typeDeCours)
                .dateDuCours(simpleDateFormat)
                .build();
    }
}
