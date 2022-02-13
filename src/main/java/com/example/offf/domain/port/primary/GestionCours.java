package com.example.offf.domain.port.primary;

import com.example.offf.domain.port.secondary.CourAdapter;
import com.example.offf.domain.model.Cour;

public class GestionCours implements com.example.offf.domain.usecases.CoursManagement {

    CourAdapter courAdapter;

    public GestionCours(CourAdapter courAdapter) {
        this.courAdapter = courAdapter;
    }

    @Override
    public Cour creerCour(Cour cour) {
        cour.isValide();
        return courAdapter.createCour(cour).get();
    }
}
