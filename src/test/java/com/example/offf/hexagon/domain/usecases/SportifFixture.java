package com.example.offf.hexagon.domain.usecases;

import com.example.offf.hexagon.domain.model.Sportif;

import java.util.Set;
import java.util.stream.Collectors;

public class SportifFixture {

    private Set<Sportif> sportifs;

    public SportifFixture(Set<Sportif> sportifs) {
        this.sportifs = sportifs;
    }

    public Set<Sportif> getSportifs() {
        return sportifs;
    }

    public Set<Long> getSportifsIds() {
        return sportifs.stream()
                .map(Sportif::getId)
                .collect(Collectors.toSet());
    }
}
