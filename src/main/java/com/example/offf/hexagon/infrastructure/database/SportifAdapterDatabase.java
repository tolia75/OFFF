package com.example.offf.hexagon.infrastructure.database;

import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.domain.port.secondary.SportifAdapter;
import com.example.offf.hexagon.infrastructure.database.dao.DaoMapper;
import com.example.offf.hexagon.infrastructure.database.dao.SportifDao;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SportifAdapterDatabase implements SportifAdapter {

    private SportifRepositoryPostgres sportifRepositoryPostgres;
    private DaoMapper daoMapper;

    public SportifAdapterDatabase(SportifRepositoryPostgres sportifRepositoryPostgres, DaoMapper daoMapper) {
        this.sportifRepositoryPostgres = sportifRepositoryPostgres;
        this.daoMapper = daoMapper;
    }

    @Override
    public Optional<Sportif> createSportif(Sportif sportif) {
        SportifDao sportifDao = sportifRepositoryPostgres.save(
                daoMapper.toSportifDao(sportif));
        return Optional.of(
                daoMapper.toSportif(sportifDao));
    }


}
