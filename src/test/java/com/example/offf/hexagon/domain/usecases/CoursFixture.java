package com.example.offf.hexagon.domain.usecases;

import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.model.TypeDeCours;
import com.example.offf.hexagon.infrastructure.database.dao.CourDAO;

import java.time.LocalDateTime;
import java.util.List;

public class CoursFixture {

    public List<Cour> getAllCours() {
        return List.of(getCour1(), getCour2(), getCour3(), getCour4());
    }

    public List<CourDAO> getAllCoursDao() {
        return List.of(getCour1Dao(), getCour2Dao(), getCour3Dao(), getCour4Dao());
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
