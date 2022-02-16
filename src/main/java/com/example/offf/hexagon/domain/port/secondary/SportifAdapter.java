package com.example.offf.hexagon.domain.port.secondary;

import com.example.offf.hexagon.domain.model.Sportif;

import java.util.Optional;

public interface SportifAdapter {
    Optional<Sportif> createSportif(Sportif sportif);
}
