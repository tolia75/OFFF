package com.example.offf.hexagon.domain.usecases;

import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.domain.model.TypeDeCours;
import com.example.offf.hexagon.domain.port.primary.ReservationImpl;
import com.example.offf.hexagon.domain.port.secondary.CourAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ReservationTest {

    private Reservation reservation;
    private CourAdapter courAdapter;
    private CoursFixture coursFixture;

    @BeforeEach
    void setUp() {
        coursFixture = new CoursFixture();
        courAdapter = new CourAdapterStub(coursFixture);
        reservation = new ReservationImpl(courAdapter);
    }


//    @Test
    void doitReserverUnCoursAvecSucces() {
        // Given
//        long sportifId = 1;
//        Sportif sportif= new Sportif();
////        Cour cour = new Cour.CourBuilder()
////                .id(2)
////                .typeDeCours(TypeDeCours.YOGA)
////                .dateDuCours(LocalDateTime.of(2022, 1, 1, 20, 00))
////                .build();
//        long courId = 2;
//        Cour expectedCour = new Cour.CourBuilder()
//                .id(2)
//                .typeDeCours(TypeDeCours.YOGA)
//                .dateDuCours(LocalDateTime.of(2022, 1, 1, 20, 00))
//                .sportifs(Set.of(sportif))
//                .build();
//
//        // When
//        Optional<Cour> courMisAJour = reservation.reserveCours(sportifId, courId);
//
//        // Assert
//        assertThat(courMisAJour.get()).isEqualTo(expectedCour);
    }
}


