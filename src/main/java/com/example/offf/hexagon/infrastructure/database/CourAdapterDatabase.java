package com.example.offf.hexagon.infrastructure.database;

import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.port.secondary.CourAdapter;
import com.example.offf.hexagon.infrastructure.database.dao.CourDAO;
import com.example.offf.hexagon.infrastructure.database.dao.DaoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class CourAdapterDatabase implements CourAdapter {

    private CourRepositoryPostgres courRepositoryPostgres;
    private DaoMapper daoMapper;

    public CourAdapterDatabase(CourRepositoryPostgres courRepositoryPostgres, DaoMapper daoMapper) {
        this.courRepositoryPostgres = courRepositoryPostgres;
        this.daoMapper = daoMapper;
    }

    @Override
    public Optional<Cour> saveCour(Cour cour) {
        CourDAO courDAO = daoMapper.toCourDAO(cour);
        return Optional.of(daoMapper.toCour(courRepositoryPostgres.save(courDAO)));
    }

    @Override
    public List<Cour> getAllCours() {
        return StreamSupport.stream(courRepositoryPostgres.findAll().spliterator(), false)
                .map(courDao -> daoMapper.toCour(courDao))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cour> addSportifsToCour(Cour cour) {
        CourDAO courDAO = courRepositoryPostgres.save(daoMapper.toCourDAO(cour));
        return Optional.of(daoMapper.toCour(courDAO));
    }
}
