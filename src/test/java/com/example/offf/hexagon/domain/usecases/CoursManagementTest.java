package com.example.offf.hexagon.domain.usecases;

import com.example.offf.hexagon.domain.exception.ObjetMetierNonValideException;
import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.domain.model.TypeDeCours;
import com.example.offf.hexagon.domain.port.primary.GestionCours;
import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.port.secondary.CourAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CoursManagementTest {

    private CoursManagement coursManagement;
    private CourAdapter courAdapter;
    private CoursFixture coursFixture;
    private SportifFixture sportifFixture;

    @BeforeEach
    void setUp() {
        sportifFixture = new SportifFixture(Set.of(createSportif(2, "nom", "prenom")));
        coursFixture = new CoursFixture();
        courAdapter = new CourAdapterStub(coursFixture, sportifFixture);
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

        assertThatThrownBy(() -> coursManagement.creerCour(courTest))
                .isInstanceOf(ObjetMetierNonValideException.class)
                .hasMessageContaining("Le cours transmis n'est pas correcte");
    }

    @Test
    void neDoitPasCreerUnCoursSiPasDeDate() {
        // Given
        Cour courTest = new Cour.CourBuilder()
                .typeDeCours(TypeDeCours.YOGA)
                .build();

        assertThatThrownBy(() -> coursManagement.creerCour(courTest))
                .isInstanceOf(ObjetMetierNonValideException.class)
                .hasMessageContaining("Le cours transmis n'est pas correcte");
    }

    @Test
    void doitRenvoyerTousLesCours() {
        // Given
        List<Cour> coursAttendus = coursFixture.getAllCours();

        // When
        List<Cour> cours = coursManagement.recupereTousLesCours();

        // Assert
        assertEquals(coursAttendus, cours);
    }

//    @Test
//    void doitAjouterUnSportifAuCour() {
//        // Given
//        LocalDateTime localDateTime = LocalDateTime.of(2022, 1, 1, 1, 1);
//        Cour courACreer = createCourTest(TypeDeCours.PILATE, localDateTime);
//        Cour courAttenduSansSportif = createCourAttendu(1, TypeDeCours.PILATE, localDateTime);
//        Cour courAttenduAvecSportif =
//                createCourAttenduAvecSportif(1, TypeDeCours.PILATE, localDateTime, Set.of(createSportif(1, "nom", "prenom")));
//
//        Cour cour = coursManagement.creerCour(courACreer);
//        assertEquals(courAttenduSansSportif, cour);
//
//        // When
//        Cour courAvecSportif = coursManagement.updateCour(courAttenduAvecSportif);
//
//        // Assert
//        assertEquals(courAttenduAvecSportif, courAvecSportif);
//
//    }

    private Cour createCourAttenduAvecSportif(int id, TypeDeCours typeDeCours, LocalDateTime dateDuCour, Set<Sportif> sportifs) {
        return new Cour.CourBuilder()
                .id(id)
                .typeDeCours(typeDeCours)
                .dateDuCours(dateDuCour)
                .sportifs(sportifs)
                .build();
    }

    private Sportif createSportif(long id, String nom, String prenom) {
        return new Sportif.SportifBuilder()
                .id(id)
                .prenom(prenom)
                .nom(nom)
                .build();
    }

    private Cour createCourAttendu(long id, TypeDeCours typeDeCours, LocalDateTime dateDuCour) {
        return new Cour.CourBuilder()
                .id(id)
                .typeDeCours(typeDeCours)
                .dateDuCours(dateDuCour)
                .build();
    }

    private Cour createCourTest(TypeDeCours typeDeCours,  LocalDateTime dateDuCour) {
        return new Cour.CourBuilder()
                .typeDeCours(typeDeCours)
                .dateDuCours(dateDuCour)
                .build();
    }
}
