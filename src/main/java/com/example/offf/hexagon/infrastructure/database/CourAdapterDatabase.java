package com.example.offf.hexagon.infrastructure.database;

import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.port.secondary.CourAdapter;
import com.example.offf.hexagon.infrastructure.database.dao.CourDAO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class CourAdapterDatabase implements CourAdapter {

    CourRepositoryPostgres courRepositoryPostgres;

    public CourAdapterDatabase(CourRepositoryPostgres courRepositoryPostgres) {
        this.courRepositoryPostgres = courRepositoryPostgres;
    }

    @Override
    public Optional<Cour> createCour(Cour cour) {
        CourDAO courDAO = toCourDAO(cour);
        return Optional.of(toCour(courRepositoryPostgres.save(courDAO)));
    }

    @Override
    public List<Cour> getAllCours() {
        return StreamSupport.stream(courRepositoryPostgres.findAll().spliterator(), false)
                .map(this::toCour)
                .collect(Collectors.toList());
    }

    private CourDAO toCourDAO(Cour cour) {
        return new CourDAO.CourDAOBuilder()
                .id(cour.getId())
                .typeDeCours(cour.getTypeDeCours())
                .dateDuCours(cour.getDateDuCours())
                .build();
    }

    private Cour toCour(CourDAO courDAO) {
        return new Cour.CourBuilder()
                .id(courDAO.getId())
                .typeDeCours(courDAO.getTypeDeCour())
                .dateDuCours(courDAO.getDateDuCour())
                .build();
    }


}
