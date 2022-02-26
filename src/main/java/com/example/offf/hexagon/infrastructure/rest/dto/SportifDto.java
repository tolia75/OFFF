package com.example.offf.hexagon.infrastructure.rest.dto;

import java.io.Serializable;

public class SportifDto implements Serializable {

    private long id;
    private String nom;
    private String prenom;

    public SportifDto(SportifDtoBuilder sportifBuilder) {
        this.id = sportifBuilder.id;
        this.nom = sportifBuilder.nom;
        this.prenom = sportifBuilder.prenom;
    }

    public SportifDto() {
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

    public static class SportifDtoBuilder {
        private long id;
        private String nom;
        private String prenom;

        public SportifDtoBuilder id(long id) {
            this.id = id;
            return this;
        }

        public SportifDtoBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public SportifDtoBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public SportifDto build() {
            return new SportifDto(this);
        }
    }
}
