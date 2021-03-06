package com.example.offf.rest;

import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.port.primary.GestionCours;
import com.example.offf.hexagon.domain.port.secondary.CourAdapter;

public class GestionCoursStub extends GestionCours {

    public GestionCoursStub(CourAdapter courAdapter) {
        super(courAdapter);
    }

    @Override
    public Cour creerCour(Cour cour) {
        return new Cour.CourBuilder()
                .typeDeCours(cour.getTypeDeCours())
                .dateDuCours(cour.getDateDuCours())
                .build();
    }
}
