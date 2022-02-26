package com.example.offf.hexagon.infrastructure.rest.dto;

import com.example.offf.hexagon.domain.model.TypeDeCours;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CourDto implements Serializable {

    @JsonProperty("id")
    private long id;
    @JsonProperty("typeDeCour")
    private TypeDeCours typeDeCour;
    @JsonProperty("dateDuCour")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dateDuCour;
    private Set<SportifDto> sportifsDtos;

    private CourDto() {
    }

    private CourDto(CourDtoBuilder courDtoBuilder) {
        this.id = courDtoBuilder.id;
        this.typeDeCour = courDtoBuilder.typeDeCour;
        this.dateDuCour = courDtoBuilder.dateDuCour;
        if (Objects.isNull(courDtoBuilder.sportifDto)) {
            this.sportifsDtos = new HashSet<>();
        } else {
            this.sportifsDtos = courDtoBuilder.sportifDto;
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

    public Set<SportifDto> getSportifsDtos() {
        return sportifsDtos;
    }

    public static class CourDtoBuilder {
        private long id;
        private TypeDeCours typeDeCour;
        private LocalDateTime dateDuCour;
        private Set<SportifDto> sportifDto;

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

        public CourDtoBuilder sportifDto(Set<SportifDto> sportifDto) {
            this.sportifDto = sportifDto;
            return this;
        }

        public CourDto build() {
            return new CourDto(this);
        }
    }
}
