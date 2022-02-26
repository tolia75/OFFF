package com.example.offf.hexagon.infrastructure.database.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity()
@Table(name = "sportif")
public class SportifDao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sportif_id")
    private long id;
    private String nom;
    private String prenom;

    public SportifDao() {
    }

    public SportifDao(SportifDaoBuilder sportifBuilder) {
        this.id = sportifBuilder.id;
        this.nom = sportifBuilder.nom;
        this.prenom = sportifBuilder.prenom;
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

    public static class SportifDaoBuilder {
        private long id;
        private String nom;
        private String prenom;

        public SportifDaoBuilder id(long id) {
            this.id = id;
            return this;
        }

        public SportifDaoBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public SportifDaoBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public SportifDao build() {
            return new SportifDao(this);
        }
    }
}
