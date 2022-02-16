package com.example.offf.hexagon.domain.port.primary;

import com.example.offf.hexagon.domain.exception.ObjetMetierNonValideException;
import com.example.offf.hexagon.domain.port.secondary.CourAdapter;
import com.example.offf.hexagon.domain.model.Cour;

import java.util.List;

public class GestionCours implements com.example.offf.hexagon.domain.usecases.CoursManagement {

    private static final String COURS_TRANSMIS_NON_CORRECT = "Le cours transmis n'est pas correcte";

    CourAdapter courAdapter;

    public GestionCours(CourAdapter courAdapter) {
        this.courAdapter = courAdapter;
    }

    @Override
    public Cour creerCour(Cour cour) {
        if (!cour.isValide()) {
            throw new ObjetMetierNonValideException(COURS_TRANSMIS_NON_CORRECT);
        }

        return courAdapter.createCour(cour).get();
    }

    @Override
    public List<Cour> recupereTousLesCours() {
        return courAdapter.getAllCours();
    }
}
