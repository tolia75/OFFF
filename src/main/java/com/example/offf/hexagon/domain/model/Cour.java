package com.example.offf.hexagon.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class Cour {

    private long id;
    private TypeDeCours typeDeCours;
    private LocalDateTime dateDuCours;
    private Set<Sportif> sportifs;

    private Cour(CourBuilder courBuilder) {
        this.id = courBuilder.id;
        this.typeDeCours = courBuilder.typeDeCours;
        this.dateDuCours = courBuilder.dateDuCours;
        this.sportifs = courBuilder.sportifs;
    }

    public long getId() {
        return id;
    }

    public TypeDeCours getTypeDeCours() {
        return typeDeCours;
    }

    public LocalDateTime getDateDuCours() {
        return dateDuCours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cour cour = (Cour) o;
        return id == cour.id &&
                typeDeCours == cour.typeDeCours &&
                Objects.equals(dateDuCours, cour.dateDuCours) &&
                Objects.equals(sportifs, cour.sportifs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeDeCours, dateDuCours, sportifs);
    }

    @Override
    public String toString() {
        return "Cour{" +
                "id=" + id +
                ", typeDeCours=" + typeDeCours +
                ", dateDuCours=" + dateDuCours +
                ", sportifs=" + sportifs +
                '}';
    }

    public boolean isValide() {
        boolean isValid = true;

        if (Objects.isNull(typeDeCours)) {
            isValid = false;
        }

        if (Objects.isNull(dateDuCours)) {
            isValid = false;
        }

        return isValid;
    }

    public static class CourBuilder {
        private long id;
        private TypeDeCours typeDeCours;
        private LocalDateTime dateDuCours;
        private Set<Sportif> sportifs;

        public CourBuilder id(long id) {
            this.id = id;
            return this;
        }

        public CourBuilder typeDeCours(TypeDeCours typeDeCours) {
            this.typeDeCours = typeDeCours;
            return this;
        }

        public CourBuilder dateDuCours(LocalDateTime dateDuCours) {
            this.dateDuCours = dateDuCours;
            return this;
        }

        public CourBuilder sportifs(Set<Sportif> sportifs) {
            this.sportifs = sportifs;
            return this;
        }

        public Cour build() {
          return new Cour(this);
        }
    }
}
