package com.example.offf.hexagon.domain.usecases;

import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.domain.model.TypeDeCours;
import com.example.offf.hexagon.infrastructure.database.dao.CourDAO;
import com.example.offf.hexagon.infrastructure.database.dao.SportifDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class CoursFixture {

    private List<Cour> cours = List.of(getCour1(), getCour2(), getCour3(), getCour4());
    private List<CourDAO> coursDaos = List.of(getCour1Dao(), getCour2Dao(), getCour3Dao(), getCour4Dao());
    private List<CourDAO> coursDaosWithSportifs = List.of(getCour1Dao(), getCour2DaoWithSportifsDao(), getCour3Dao(), getCour4Dao());

    public List<Cour> getAllCours() {
        return cours;
    }

    private Cour getCour1() {
        return new Cour.CourBuilder()
                .id(1)
                .typeDeCours(TypeDeCours.YOGA)
                .dateDuCours(LocalDateTime.of(2022, 1, 1, 1, 1, 1))
                .build();
    }

    private Cour getCour2() {
        return new Cour.CourBuilder()
                .id(2)
                .typeDeCours(TypeDeCours.HIIT)
                .dateDuCours(LocalDateTime.of(2022, 1, 2, 1, 1, 1))
                .build();
    }

    public Cour getCour2WithSportifs() {
        return new Cour.CourBuilder()
                .id(2)
                .typeDeCours(TypeDeCours.HIIT)
                .dateDuCours(LocalDateTime.of(2022, 1, 2, 1, 1, 1))
                .sportifs(Set.of(new Sportif.SportifBuilder()
                    .id(2L)
                    .nom("nom")
                    .prenom("prenom")
                    .build()))
                .build();
    }

    private Cour getCour3() {
        return new Cour.CourBuilder()
                .id(3)
                .typeDeCours(TypeDeCours.PILATE)
                .dateDuCours(LocalDateTime.of(2022, 1, 3, 1, 1, 1))
                .build();
    }

    private Cour getCour4() {
        return new Cour.CourBuilder()
                .id(4)
                .typeDeCours(TypeDeCours.ZUMBA)
                .dateDuCours(LocalDateTime.of(2022, 1, 4, 1, 1, 1))
                .build();
    }

    private CourDAO getCour1Dao() {
        return new CourDAO.CourDAOBuilder()
                .id(1)
                .typeDeCours(TypeDeCours.YOGA)
                .dateDuCours(LocalDateTime.of(2022, 1, 1, 1, 1, 1))
                .build();
    }

    private CourDAO getCour2Dao() {
        return new CourDAO.CourDAOBuilder()
                .id(2)
                .typeDeCours(TypeDeCours.HIIT)
                .dateDuCours(LocalDateTime.of(2022, 1, 2, 1, 1, 1))
                .build();
    }

    public CourDAO getCour2DaoWithSportifsDao() {
        return new CourDAO.CourDAOBuilder()
                .id(2)
                .typeDeCours(TypeDeCours.HIIT)
                .dateDuCours(LocalDateTime.of(2022, 1, 2, 1, 1, 1))
                .sportifs(Set.of(new SportifDao.SportifDaoBuilder()
                    .id(2)
                    .nom("nom")
                    .prenom("prenom")
                    .build()))
                .build();
    }

    private CourDAO getCour3Dao() {
        return new CourDAO.CourDAOBuilder()
                .id(3)
                .typeDeCours(TypeDeCours.PILATE)
                .dateDuCours(LocalDateTime.of(2022, 1, 3, 1, 1, 1))
                .build();
    }

    private CourDAO getCour4Dao() {
        return new CourDAO.CourDAOBuilder()
                .id(4)
                .typeDeCours(TypeDeCours.ZUMBA)
                .dateDuCours(LocalDateTime.of(2022, 1, 4, 1, 1, 1))
                .build();
    }
}
