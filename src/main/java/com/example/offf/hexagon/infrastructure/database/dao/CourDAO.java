package com.example.offf.hexagon.infrastructure.database.dao;

import com.example.offf.hexagon.domain.model.TypeDeCours;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;

@Entity()
@Table(name = "cour")
public class CourDAO {

    @Id
    private long id;
    private TypeDeCours typeDeCours;
    private SimpleDateFormat dateDuCours;

    private CourDAO(CourDAOBuilder courDAOBuilder) {
        this.id = courDAOBuilder.id;
        this.typeDeCours = courDAOBuilder.typeDeCours;
        this.dateDuCours = courDAOBuilder.dateDuCours;
    }

    public long getId() {
        return id;
    }

    public TypeDeCours getTypeDeCours() {
        return typeDeCours;
    }

    public SimpleDateFormat getDateDuCours() {
        return dateDuCours;
    }

    public static class CourDAOBuilder {
        private long id;
        private TypeDeCours typeDeCours;
        private SimpleDateFormat dateDuCours;

        public CourDAOBuilder id(long id) {
            this.id = id;
            return this;
        }

        public CourDAOBuilder typeDeCours(TypeDeCours typeDeCours) {
            this.typeDeCours = typeDeCours;
            return this;
        }

        public CourDAOBuilder dateDuCours(SimpleDateFormat dateDuCours) {
            this.dateDuCours = dateDuCours;
            return this;
        }

        public CourDAO build() {
            return new CourDAO(this);
        }
    }
}
