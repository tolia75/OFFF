package com.example.offf.database;

import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.infrastructure.database.SportifAdapterDatabase;
import com.example.offf.hexagon.infrastructure.database.SportifRepositoryPostgres;
import com.example.offf.hexagon.infrastructure.database.dao.DaoMapper;
import com.example.offf.hexagon.infrastructure.database.dao.SportifDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class SportifAdapterDatabaseTests {

    @Autowired
    SportifRepositoryPostgres sportifRepositoryPostgres;
    SportifAdapterDatabase sportifAdapterDatabase;

    @BeforeEach
    void setUp() {
        sportifAdapterDatabase = new SportifAdapterDatabase(sportifRepositoryPostgres, new DaoMapper());
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

        Optional<Sportif> sportif = sportifAdapterDatabase.createSportif(sportifWithoutId);

        assertThat(sportif.get()).isEqualTo(sportifWithId);
    }
}
