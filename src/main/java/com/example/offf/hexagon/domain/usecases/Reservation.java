package com.example.offf.hexagon.domain.usecases;

import com.example.offf.hexagon.domain.model.Cour;

import java.util.Optional;

public interface Reservation {

    Optional<Cour> reserveCours(Cour cour);
}
