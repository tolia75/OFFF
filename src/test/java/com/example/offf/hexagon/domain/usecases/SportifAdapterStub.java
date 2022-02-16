package com.example.offf.hexagon.domain.usecases;

import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.domain.port.secondary.SportifAdapter;

import java.util.Optional;

public class SportifAdapterStub implements SportifAdapter {

    @Override
    public Optional<Sportif> createSportif(Sportif sportif) {
        return Optional.of(new Sportif.SportifBuilder()
        .id(1)
        .nom("nom")
        .prenom("prenom")
        .build());
    }
}
