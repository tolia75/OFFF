package com.example.offf.hexagon.infrastructure.database;

import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.domain.port.secondary.SportifAdapter;
import com.example.offf.hexagon.infrastructure.database.dao.SportifDao;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SportifAdapterDatabase implements SportifAdapter {

    private SportifRepositoryPostgres sportifRepositoryPostgres;

    public SportifAdapterDatabase(SportifRepositoryPostgres sportifRepositoryPostgres) {
        this.sportifRepositoryPostgres = sportifRepositoryPostgres;
    }

    @Override
    public Optional<Sportif> createSportif(Sportif sportif) {
        SportifDao sportifDao = sportifRepositoryPostgres.save(toSportifDao(sportif));
        return Optional.of(toSportif(sportifDao));
    }

    private Sportif toSportif(SportifDao sportifDao) {
        return new Sportif.SportifBuilder()
                .id(sportifDao.getId())
                .nom(sportifDao.getNom())
                .prenom(sportifDao.getPrenom())
                .build();
    }

    private SportifDao toSportifDao(Sportif sportif) {
        return new SportifDao.SportifDaoBuilder()
                .id(sportif.getId())
                .nom(sportif.getNom())
                .prenom(sportif.getPrenom())
                .build();
    }
}
