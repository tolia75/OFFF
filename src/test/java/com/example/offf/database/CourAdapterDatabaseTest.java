package com.example.offf.database;

import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.domain.model.TypeDeCours;
import com.example.offf.hexagon.domain.usecases.CoursFixture;
import com.example.offf.hexagon.infrastructure.database.CourAdapterDatabase;
import com.example.offf.hexagon.infrastructure.database.CourRepositoryPostgres;
import com.example.offf.hexagon.infrastructure.database.SportifRepositoryPostgres;
import com.example.offf.hexagon.infrastructure.database.dao.CourDAO;
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

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CourAdapterDatabaseTest {

    @Autowired
    private CourRepositoryPostgres courRepositoryPostgres;
    @Autowired
    private SportifRepositoryPostgres sportifRepositoryPostgres;
    private CourAdapterDatabase courAdapterDatabase;
    private CoursFixture coursFixture;

    @BeforeEach
    void setUp() {
        coursFixture = new CoursFixture();
        courAdapterDatabase = new CourAdapterDatabase(courRepositoryPostgres, new DaoMapper());
    }

    @Test
    void doitCreerCourDeTypeYoga() {
        // Given
        LocalDateTime localDateTime = LocalDateTime.of(2022, 1, 1, 1, 1);
        Cour courTest = createCourTest(TypeDeCours.YOGA, localDateTime);
        Cour courAttendu = createCourAttendu(1, TypeDeCours.YOGA, localDateTime);

        // When
        Optional<Cour> courOptional = courAdapterDatabase.saveCour(courTest);

        // Assert
        assertEquals(courAttendu, courOptional.get());
    }

    @Test
    void doitRecupererTousLesCours() {
        // Given
        List<Cour> courAttendus = coursFixture.getAllCours();
        List<Cour> cours;
        cours = courAdapterDatabase.getAllCours();
        assertTrue(cours.isEmpty());
        courAttendus.forEach(cour -> courAdapterDatabase.saveCour(cour));

        // When
        cours = courAdapterDatabase.getAllCours();

        // Assert
        assertEquals(4, cours.size());
        assertEquals(courAttendus, cours);
    }

    @Test
    void doitAjouterSportifAUnCour() {
        // Given
        Set<Sportif> sportifs = new HashSet<>();
        sportifs.add(new Sportif.SportifBuilder()
                .id(1)
                .nom("nom")
                .prenom("prenom")
                .build());
        Cour courAttendu = new Cour.CourBuilder()
                .id(1)
                .typeDeCours(TypeDeCours.YOGA)
                .dateDuCours(LocalDateTime.of(2022, 1, 1, 20, 20))
                .sportifs(sportifs)
                .build();
        courRepositoryPostgres.save(new CourDAO.CourDAOBuilder()
            .typeDeCours(TypeDeCours.YOGA)
            .dateDuCours(LocalDateTime.of(2022, 1, 1, 20, 20))
            .build());
        sportifRepositoryPostgres.save(new SportifDao.SportifDaoBuilder()
            .nom("nom")
            .prenom("prenom")
            .build());


        // When
        Optional<Cour> cour = courAdapterDatabase.addSportifsToCour(courAttendu);

        // Assert
        assertEquals(courAttendu, cour.get());
    }

    private Cour createCourAttendu(long id, TypeDeCours typeDeCours, LocalDateTime localDateTime) {
        return new Cour.CourBuilder()
                .id(id)
                .typeDeCours(typeDeCours)
                .dateDuCours(localDateTime)
                .build();
    }

    private Cour createCourTest(TypeDeCours typeDeCours, LocalDateTime localDateTime) {
        return new Cour.CourBuilder()
                .typeDeCours(typeDeCours)
                .dateDuCours(localDateTime)
                .build();
    }
}
