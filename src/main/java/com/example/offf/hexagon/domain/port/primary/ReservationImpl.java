package com.example.offf.hexagon.domain.port.primary;

import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.port.secondary.CourAdapter;
import com.example.offf.hexagon.domain.usecases.Reservation;

import java.util.Optional;

public class ReservationImpl implements Reservation {

    private CourAdapter courAdapter;

    public ReservationImpl(CourAdapter courAdapter) {
        this.courAdapter = courAdapter;
    }

    @Override
    public Optional<Cour> reserveCours(long sportifId, long idCours) {
        return Optional.empty();
//                courAdapter.addSportifToCour(sportifId, idCours);
    }
}
