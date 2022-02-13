package com.example.offf.hexagon.infrastructure.rest.dto;

import com.example.offf.hexagon.domain.model.TypeDeCours;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CourDto implements Serializable {

    @JsonProperty("id")
    private long id;
    @JsonProperty("typeDeCour")
    private TypeDeCours typeDeCour;
    @JsonProperty("dateDuCour")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dateDuCour;

    private CourDto() {
    }

    private CourDto(CourDtoBuilder courDAOBuilder) {
        this.id = courDAOBuilder.id;
        this.typeDeCour = courDAOBuilder.typeDeCour;
        this.dateDuCour = courDAOBuilder.dateDuCour;
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

    public static class CourDtoBuilder {
        private long id;
        private TypeDeCours typeDeCour;
        private LocalDateTime dateDuCour;

        public CourDtoBuilder id(long id) {
            this.id = id;
            return this;
        }

        public CourDtoBuilder typeDeCour(TypeDeCours typeDeCour) {
            this.typeDeCour = typeDeCour;
            return this;
        }

        public CourDtoBuilder dateDuCour(LocalDateTime dateDuCour) {
            this.dateDuCour = dateDuCour;
            return this;
        }

        public CourDto build() {
            return new CourDto(this);
        }
    }
}
