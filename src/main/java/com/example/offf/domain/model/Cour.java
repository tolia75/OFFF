package com.example.offf.domain.model;

import com.example.offf.domain.exception.ObjetMetierNonValideException;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class Cour {

    private static final String COURS_TRANSMIS_NON_CORRECT = "Le cours transmis n'est pas correcte";
    private long id;
    private TypeDeCours typeDeCours;
    private SimpleDateFormat dateDuCours;

    private Cour(CourBuilder courBuilder) {
        this.id = courBuilder.id;
        this.typeDeCours = courBuilder.typeDeCours;
        this.dateDuCours = courBuilder.dateDuCours;

    }

    public TypeDeCours getTypeDeCours() {
        return typeDeCours;
    }

    public SimpleDateFormat getDateDuCours() {
        return dateDuCours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cour cour = (Cour) o;
        return id == cour.id &&
                typeDeCours == cour.typeDeCours &&
                Objects.equals(dateDuCours, cour.dateDuCours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeDeCours, dateDuCours);
    }

    @Override
    public String toString() {
        return "Cour{" +
                "id=" + id +
                ", typeDeCours=" + typeDeCours +
                ", simpleDateFormat=" + dateDuCours +
                '}';
    }

    public void isValide() {
        boolean isValid = true;

        if (null == typeDeCours) {
            isValid = false;
        }

        if (null == dateDuCours) {
            isValid = false;
        }

        if (!isValid) {
            throw new ObjetMetierNonValideException(COURS_TRANSMIS_NON_CORRECT);
        }
    }

    public static class CourBuilder {
        private long id;
        private TypeDeCours typeDeCours;
        private SimpleDateFormat dateDuCours;

        public CourBuilder id(long id) {
            this.id = id;
            return this;
        }

        public CourBuilder typeDeCours(TypeDeCours typeDeCours) {
            this.typeDeCours = typeDeCours;
            return this;
        }

        public CourBuilder dateDuCours(SimpleDateFormat dateDuCours) {
            this.dateDuCours = dateDuCours;
            return this;
        }

        public Cour build() {
          return new Cour(this);
        }


    }
}
