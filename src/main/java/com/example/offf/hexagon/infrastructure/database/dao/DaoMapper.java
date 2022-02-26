package com.example.offf.hexagon.infrastructure.database.dao;

import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.model.Sportif;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DaoMapper {
    public CourDAO toCourDAO(Cour cour) {
        Set<SportifDao> sportifs = getSportifsDaoFromCour(cour);
        return new CourDAO.CourDAOBuilder()
                .id(cour.getId())
                .typeDeCours(cour.getTypeDeCours())
                .dateDuCours(cour.getDateDuCours())
                .sportifs(sportifs)
                .build();
    }

    private Set<SportifDao> getSportifsDaoFromCour(Cour cour) {
        Set<SportifDao> sportifs = new HashSet<>();
        cour.getSportifs().forEach(sportif -> sportifs.add(toSportifDao(sportif)));
        return sportifs;
    }

    public Cour toCour(CourDAO courDAO) {
        return new Cour.CourBuilder()
                .id(courDAO.getId())
                .typeDeCours(courDAO.getTypeDeCour())
                .dateDuCours(courDAO.getDateDuCour())
                .sportifs(courDAO.getSportifsDaos().stream().map(this::toSportif).collect(Collectors.toSet()))
                .build();
    }

    public Sportif toSportif(SportifDao sportifDao) {
        return new Sportif.SportifBuilder()
                .id(sportifDao.getId())
                .nom(sportifDao.getNom())
                .prenom(sportifDao.getPrenom())
                .build();
    }

    public SportifDao toSportifDao(Sportif sportif) {
        return new SportifDao.SportifDaoBuilder()
                .id(sportif.getId())
                .nom(sportif.getNom())
                .prenom(sportif.getPrenom())
                .build();
    }
}
