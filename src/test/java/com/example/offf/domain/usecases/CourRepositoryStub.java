package com.example.offf.domain.usecases;

import com.example.offf.domain.model.Cour;
import com.example.offf.domain.port.secondary.CourRepository;

import java.util.Optional;

public class CourRepositoryStub implements CourRepository {


    @Override
    public Optional<Cour> createCour(Cour cour) {
        return Optional.of(new Cour.CourBuilder()
                .id(1)
                .typeDeCours(cour.getTypeDeCours())
                .dateDuCours(cour.getDateDuCours())
                .build());
    }
}
