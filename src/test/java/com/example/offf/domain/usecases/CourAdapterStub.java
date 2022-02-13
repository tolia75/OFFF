package com.example.offf.domain.usecases;

import com.example.offf.domain.model.Cour;
import com.example.offf.domain.port.secondary.CourAdapter;

import java.util.Optional;

public class CourAdapterStub implements CourAdapter {


    @Override
    public Optional<Cour> createCour(Cour cour) {
        return Optional.of(new Cour.CourBuilder()
                .id(1)
                .typeDeCours(cour.getTypeDeCours())
                .dateDuCours(cour.getDateDuCours())
                .build());
    }
}