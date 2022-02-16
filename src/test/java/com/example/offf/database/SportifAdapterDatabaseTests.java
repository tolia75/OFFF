package com.example.offf.database;

import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.infrastructure.database.SportifAdapterDatabase;
import com.example.offf.hexagon.infrastructure.database.SportifRepositoryPostgres;
import com.example.offf.hexagon.infrastructure.database.dao.SportifDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class SportifAdapterDatabaseTests {

    @Mock
    SportifRepositoryPostgres sportifRepositoryPostgres;
    SportifAdapterDatabase sportifAdapterDatabase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        sportifAdapterDatabase = new SportifAdapterDatabase(sportifRepositoryPostgres);
    }

    @Test
    void doitCreerEtTransmettreNouveauSportif() {
        SportifDao sportifDao = new SportifDao.SportifDaoBuilder()
                .id(1)
                .nom("nom")
                .prenom("prenom")
                .build();
        Sportif sportifWithoutId = new Sportif.SportifBuilder()
                .nom("nom")
                .prenom("prenom")
                .build();
        Sportif sportifWithId = new Sportif.SportifBuilder()
                .id(1)
                .nom("nom")
                .prenom("prenom")
                .build();
        when(sportifRepositoryPostgres.save(any())).thenReturn(sportifDao);


        Optional<Sportif> sportif = sportifAdapterDatabase.createSportif(sportifWithoutId);

        assertThat(sportif.get()).isEqualTo(sportifWithId);
    }
}
