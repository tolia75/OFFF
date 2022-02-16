package com.example.offf.hexagon.domain.model;

import java.util.Objects;

public class Sportif {
    private long id;
    private String nom;
    private String prenom;

    public Sportif(SportifBuilder sportifBuilder) {
        this.id = sportifBuilder.id;
        this.nom = sportifBuilder.nom;
        this.prenom = sportifBuilder.prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sportif sportif = (Sportif) o;
        return id == sportif.id &&
                nom.equals(sportif.nom) &&
                prenom.equals(sportif.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom);
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public boolean isValid() {
        boolean isValid = true;

        if (Objects.isNull(nom) || nom.isEmpty()) {
            isValid = false;
        }

        if (Objects.isNull(prenom) || prenom.isEmpty()) {
            isValid = false;
        }

        return isValid;
    }

    public static class SportifBuilder {
        private long id;
        private String nom;
        private String prenom;

        public SportifBuilder id(long id) {
            this.id = id;
            return this;
        }

        public SportifBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public SportifBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public Sportif build() {
            return new Sportif(this);
        }
    }
}
