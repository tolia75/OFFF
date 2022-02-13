package com.example.offf.hexagon.domain.usecases;

import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.port.secondary.CourAdapter;

import java.util.List;
import java.util.Optional;

public class CourAdapterStub implements CourAdapter {

    private CoursFixture coursFixture;

    public CourAdapterStub(CoursFixture coursFixture) {
        this.coursFixture = coursFixture;
    }

    @Override
    public Optional<Cour> createCour(Cour cour) {
        return Optional.of(new Cour.CourBuilder()
                .id(1)
                .typeDeCours(cour.getTypeDeCours())
                .dateDuCours(cour.getDateDuCours())
                .build());
    }

    @Override
    public List<Cour> getAllCours() {
        return coursFixture.getAllCours();
    }
}
