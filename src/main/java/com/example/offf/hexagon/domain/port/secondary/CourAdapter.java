package com.example.offf.hexagon.domain.port.secondary;

import com.example.offf.hexagon.domain.model.Cour;

import java.util.List;
import java.util.Optional;

public interface CourAdapter {
    Optional<Cour> createCour(Cour cour);

    List<Cour> getAllCours();
}
