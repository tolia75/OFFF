package com.example.offf.hexagon.domain.usecases;

import com.example.offf.hexagon.domain.model.Cour;

import java.util.List;

public interface CoursManagement {
    Cour creerCour(Cour cour);

    List<Cour> recupereTousLesCours();
}
