package com.example.offf.hexagon.infrastructure.database;

import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.domain.port.secondary.SportifAdapter;

import java.util.Optional;

public class SportifAdapterDatabase implements SportifAdapter {

    @Override
    public Optional<Sportif> createSportif(Sportif sportif) {
        return Optional.empty();
    }
}
