package com.example.offf.domain.port.secondary;

import com.example.offf.domain.model.Cour;

import java.util.Optional;

public interface CourAdapter {
    Optional<Cour> createCour(Cour cour);
}
