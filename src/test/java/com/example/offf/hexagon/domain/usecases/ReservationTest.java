package com.example.offf.hexagon.domain.usecases;

import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.domain.model.TypeDeCours;
import com.example.offf.hexagon.domain.port.primary.ReservationImpl;
import com.example.offf.hexagon.domain.port.secondary.CourAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ReservationTest {

    private Reservation reservation;
    private CourAdapter courAdapter;
    private CoursFixture coursFixture;
    private SportifFixture sportifFixture;

    @BeforeEach
    void setUp() {
        sportifFixture = new SportifFixture(new HashSet<>());
        coursFixture = new CoursFixture();
        courAdapter = new CourAdapterStub(coursFixture, sportifFixture);
        reservation = new ReservationImpl(courAdapter);
    }

    @Test
    void doitReserverUnCoursAvecSucces() {
        // Given
        long sportifId = 1;
        Sportif sportif= new Sportif.SportifBuilder()
                .id(sportifId)
                .nom("nom")
                .prenom("prenom")
                .build();

        long courId = 1;
        Cour expectedCour = new Cour.CourBuilder()
                .id(courId)
                .typeDeCours(TypeDeCours.YOGA)
                .dateDuCours(LocalDateTime.of(2022, 1, 1, 20, 20))
                .sportifs(Set.of(sportif))
                .build();

        // When
        Optional<Cour> courMisAJour = reservation.reserveCours(expectedCour);

        // Assert
        assertThat(courMisAJour.get()).isEqualTo(expectedCour);
    }

    @Test
    void neDoitPasReserverUnCoursCarPasDID() {
        // Given
        long sportifId = 1;
        Sportif sportif= new Sportif.SportifBuilder()
                .id(sportifId)
                .nom("nom")
                .prenom("prenom")
                .build();

        long courId = 1;
        Cour expectedCour = new Cour.CourBuilder()
                .id(courId)
                .typeDeCours(TypeDeCours.YOGA)
                .dateDuCours(LocalDateTime.of(2022, 1, 1, 20, 20))
                .sportifs(Set.of(sportif))
                .build();

        // When
        Optional<Cour> courMisAJour = reservation.reserveCours(expectedCour);

        // Assert
        assertThat(courMisAJour.get()).isEqualTo(expectedCour);
    }

}


