package com.example.offf.domain.port.primary;

import com.example.offf.domain.port.secondary.CourRepository;
import com.example.offf.domain.model.Cour;

public class GestionCours implements com.example.offf.domain.usecases.CoursManagement {

    CourRepository courRepository;

    public GestionCours(CourRepository courRepository) {
        this.courRepository = courRepository;
    }

    @Override
    public Cour creerCour(Cour cour) {
        cour.isValide();
        return courRepository.createCour(cour).get();
    }
}
