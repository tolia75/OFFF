package com.example.offf.infrastructure.database;

import com.example.offf.domain.model.Cour;
import com.example.offf.domain.port.secondary.CourAdapter;
import com.example.offf.infrastructure.database.dao.CourDAO;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
                .typeDeCours(courDAO.getTypeDeCours())
                .dateDuCours(courDAO.getDateDuCours())
                .build();
    }


}