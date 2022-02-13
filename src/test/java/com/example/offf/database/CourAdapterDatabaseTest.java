package com.example.offf.database;

import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.model.TypeDeCours;
import com.example.offf.hexagon.infrastructure.database.CourAdapterDatabase;
import com.example.offf.hexagon.infrastructure.database.CourRepositoryPostgres;
import com.example.offf.hexagon.infrastructure.database.dao.CourDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CourAdapterDatabaseTest {

    @Mock
    CourRepositoryPostgres courRepositoryPostgres;
    CourAdapterDatabase courAdapterDatabase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        courAdapterDatabase = new CourAdapterDatabase(courRepositoryPostgres);
    }

    @Test
    void doitCreerCourDeTypeYoga() {
        // Given
        LocalDateTime localDateTime = LocalDateTime.of(2022, 1, 1, 1, 1);
        Cour courTest = createCourTest(TypeDeCours.YOGA, localDateTime);
        Cour courAttendu = createCourAttendu(1, TypeDeCours.YOGA, localDateTime);
        when(courRepositoryPostgres.save(any())).thenReturn(new CourDAO.CourDAOBuilder()
            .id(1)
            .typeDeCours(TypeDeCours.YOGA)
            .dateDuCours(localDateTime)
            .build());

        // When
        Optional<Cour> courOptional = courAdapterDatabase.createCour(courTest);

        // Assert
        assertEquals(courAttendu, courOptional.get());
    }

    private Cour createCourAttendu(long id, TypeDeCours typeDeCours, LocalDateTime localDateTime) {
        return new Cour.CourBuilder()
                .id(1)
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
