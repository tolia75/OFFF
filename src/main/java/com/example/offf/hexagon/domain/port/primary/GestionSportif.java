package com.example.offf.hexagon.domain.port.primary;

import com.example.offf.hexagon.domain.exception.ObjetMetierNonValideException;
import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.domain.port.secondary.SportifAdapter;
import com.example.offf.hexagon.domain.usecases.SportifManagement;

import java.util.Optional;

public class GestionSportif implements SportifManagement {

    private static final String SPORTIF_NON_VALIDE = "Le sportif à créer n'est pas valide";
    private SportifAdapter sportifAdapter;

    public GestionSportif(SportifAdapter sportifAdapter) {
        this.sportifAdapter = sportifAdapter;
    }

    @Override
    public Optional<Sportif> createSportif(Sportif sportif) {
        if (!sportif.isValid()) {
            throw new ObjetMetierNonValideException(SPORTIF_NON_VALIDE);
        }
        return sportifAdapter.createSportif(sportif);
    }
}
