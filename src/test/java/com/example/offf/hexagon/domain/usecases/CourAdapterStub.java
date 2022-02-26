package com.example.offf.hexagon.domain.usecases;

import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.domain.model.TypeDeCours;
import com.example.offf.hexagon.domain.port.secondary.CourAdapter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CourAdapterStub implements CourAdapter {

    private CoursFixture coursFixture;
    private SportifFixture sportifFixture;

    public CourAdapterStub(CoursFixture coursFixture, SportifFixture sportifFixture) {
        this.coursFixture = coursFixture;
        this.sportifFixture = sportifFixture;
    }

    @Override
    public Optional<Cour> saveCour(Cour cour) {
        return Optional.of(new Cour.CourBuilder()
                .id(1)
                .typeDeCours(cour.getTypeDeCours())
                .dateDuCours(cour.getDateDuCours())
                .sportifs(cour.getSportifs())
                .build());
    }

    @Override
    public List<Cour> getAllCours() {
        return coursFixture.getAllCours();
    }

    @Override
    public Optional<Cour> addSportifsToCour(Cour cour) {
        return Optional.of(new Cour.CourBuilder()
        .id(1)
        .typeDeCours(TypeDeCours.YOGA)
        .dateDuCours(LocalDateTime.of(2022, 1,1, 20, 20))
        .sportifs(Set.of(new Sportif.SportifBuilder()
            .id(1)
            .nom("nom")
            .prenom("prenom")
            .build()))
        .build());
    }
}
