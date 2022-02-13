package com.example.offf.hexagon.infrastructure.rest.dto;

import com.example.offf.hexagon.domain.model.TypeDeCours;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CourDto implements Serializable {

    @JsonProperty("id")
    private long id;
    @JsonProperty("typeDeCours")
    private TypeDeCours typeDeCours;
    @JsonProperty("dateDuCours")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dateDuCours;

    private CourDto() {
    }

    private CourDto(CourDtoBuilder courDAOBuilder) {
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

    public LocalDateTime getDateDuCours() {
        return dateDuCours;
    }

    public static class CourDtoBuilder {
        private long id;
        private TypeDeCours typeDeCours;
        private LocalDateTime dateDuCours;

        public CourDtoBuilder id(long id) {
            this.id = id;
            return this;
        }

        public CourDtoBuilder typeDeCours(TypeDeCours typeDeCours) {
            this.typeDeCours = typeDeCours;
            return this;
        }

        public CourDtoBuilder dateDuCours(LocalDateTime dateDuCours) {
            this.dateDuCours = dateDuCours;
            return this;
        }

        public CourDto build() {
            return new CourDto(this);
        }
    }
}
