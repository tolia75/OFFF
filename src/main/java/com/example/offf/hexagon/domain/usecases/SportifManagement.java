package com.example.offf.hexagon.domain.usecases;

import com.example.offf.hexagon.domain.model.Sportif;

import java.util.Optional;

public interface SportifManagement {
    Optional<Sportif> createSportif(Sportif sportif);
}
