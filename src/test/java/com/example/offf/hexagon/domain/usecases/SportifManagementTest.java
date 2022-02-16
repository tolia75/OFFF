package com.example.offf.hexagon.domain.usecases;

import com.example.offf.hexagon.domain.exception.ObjetMetierNonValideException;
import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.domain.port.primary.GestionSportif;
import com.example.offf.hexagon.domain.port.secondary.SportifAdapter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SportifManagementTest {

    private SportifManagement sportifManagement;
    private SportifAdapter sportifAdapter;
    @BeforeEach
    void setUp() {
        sportifAdapter = new SportifAdapterStub();
        sportifManagement = new GestionSportif(sportifAdapter);
    }

    @Test
    void doitCreerNouveauSportif() {
        Sportif expectedSportif = new Sportif.SportifBuilder()
                .id(1)
                .nom("nom")
                .prenom("prenom")
                .build();
        Sportif sportifWithoutId = new Sportif.SportifBuilder()
                .nom("nom")
                .prenom("prenom")
                .build();

        Optional<Sportif> sportif = sportifManagement.createSportif(sportifWithoutId);

        assertThat(sportif.get())
                .isEqualTo(expectedSportif);
    }

    @Test
    void neDoitPasCreerNouveauSportifCarNomNull() {
        Sportif sportifWithoutId = new Sportif.SportifBuilder()
                .prenom("prenom")
                .build();

        assertThatThrownBy(() -> sportifManagement.createSportif(sportifWithoutId))
        .isInstanceOf(ObjetMetierNonValideException.class)
        .hasMessageContaining("Le sportif à créer n'est pas valide");
    }

    @Test
    void neDoitPasCreerNouveauSportifCarNomVide() {
        Sportif sportifWithoutId = new Sportif.SportifBuilder()
                .nom("")
                .prenom("prenom")
                .build();

        assertThatThrownBy(() -> sportifManagement.createSportif(sportifWithoutId))
                .isInstanceOf(ObjetMetierNonValideException.class)
                .hasMessageContaining("Le sportif à créer n'est pas valide");
    }

    @Test
    void neDoitPasCreerNouveauSportifCarPrenomNull() {
        Sportif sportifWithoutId = new Sportif.SportifBuilder()
                .nom("prenom")
                .build();

        assertThatThrownBy(() -> sportifManagement.createSportif(sportifWithoutId))
                .isInstanceOf(ObjetMetierNonValideException.class)
                .hasMessageContaining("Le sportif à créer n'est pas valide");

    }

    @Test
    void neDoitPasCreerNouveauSportifCarPrenomVide() {
        Sportif sportifWithoutId = new Sportif.SportifBuilder()
                .nom("nom")
                .prenom("")
                .build();

        assertThatThrownBy(() -> sportifManagement.createSportif(sportifWithoutId))
                .isInstanceOf(ObjetMetierNonValideException.class)
                .hasMessageContaining("Le sportif à créer n'est pas valide");

    }
}
