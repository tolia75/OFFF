package com.example.offf.hexagon.infrastructure.database.dao;

import com.example.offf.hexagon.domain.model.TypeDeCours;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity()
@Table(name = "cour")
public class CourDAO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cour_id")
    private long id;
    private TypeDeCours typeDeCour;
    private LocalDateTime dateDuCour;
    @OneToMany
    @JoinTable(name = "cour_sportif",
    joinColumns = @JoinColumn(name = "cour_id", referencedColumnName = "cour_id"),
    inverseJoinColumns = @JoinColumn(name = "sportif_id", referencedColumnName = "sportif_id", unique = true))
    private Set<SportifDao> sportifsDaos = new HashSet<>();


    public CourDAO() {
    }

    private CourDAO(CourDAOBuilder courDAOBuilder) {
        this.id = courDAOBuilder.id;
        this.typeDeCour = courDAOBuilder.typeDeCours;
        this.dateDuCour = courDAOBuilder.dateDuCours;
        if (Objects.isNull(courDAOBuilder.sportifsDaos)) {
            this.sportifsDaos = new HashSet<>();
        } else {
            this.sportifsDaos = courDAOBuilder.sportifsDaos;
        }
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

    public Set<SportifDao> getSportifsDaos() {
        return sportifsDaos;
    }

    public static class CourDAOBuilder {
        private long id;
        private TypeDeCours typeDeCours;
        private LocalDateTime dateDuCours;
        private Set<SportifDao> sportifsDaos;

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

        public CourDAOBuilder sportifs(Set<SportifDao> sportifsDaos) {
            this.sportifsDaos = sportifsDaos;
            return this;
        }
        public CourDAO build() {
            return new CourDAO(this);
        }

    }
}
