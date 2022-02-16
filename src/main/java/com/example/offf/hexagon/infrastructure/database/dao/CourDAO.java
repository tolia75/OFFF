package com.example.offf.hexagon.infrastructure.database.dao;

import com.example.offf.hexagon.domain.model.TypeDeCours;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity()
@Table(name = "cour")
public class CourDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cour_id")
    private long id;
    private TypeDeCours typeDeCour;
    private LocalDateTime dateDuCour;

    public CourDAO() {
    }

    private CourDAO(CourDAOBuilder courDAOBuilder) {
        this.id = courDAOBuilder.id;
        this.typeDeCour = courDAOBuilder.typeDeCours;
        this.dateDuCour = courDAOBuilder.dateDuCours;
    }

    public long getId() {
        return id;
    }

    public TypeDeCours getTypeDeCour() {
        return typeDeCour;
    }

    public LocalDateTime getDateDuCour() {
        return dateDuCour;
    }

    public static class CourDAOBuilder {
        private long id;
        private TypeDeCours typeDeCours;
        private LocalDateTime dateDuCours;

        public CourDAOBuilder id(long id) {
            this.id = id;
            return this;
        }

        public CourDAOBuilder typeDeCours(TypeDeCours typeDeCours) {
            this.typeDeCours = typeDeCours;
            return this;
        }

        public CourDAOBuilder dateDuCours(LocalDateTime dateDuCours) {
            this.dateDuCours = dateDuCours;
            return this;
        }

        public CourDAO build() {
            return new CourDAO(this);
        }
    }
}
