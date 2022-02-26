package com.example.offf.hexagon.infrastructure.rest.dto;

import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.model.Sportif;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DtoMapper {

    public CourDto toCourDto(Cour cour) {
        return new CourDto.CourDtoBuilder()
                .id(cour.getId())
                .typeDeCour(cour.getTypeDeCours())
                .dateDuCour(cour.getDateDuCours())
                .sportifDto(cour.getSportifs().stream().map(this::toSportifDto).collect(Collectors.toSet()))
                .build();
    }

    public Cour toCour(CourDto courDto) {
        return new Cour.CourBuilder()
                .id(courDto.getId())
                .typeDeCours(courDto.getTypeDeCour())
                .dateDuCours(courDto.getDateDuCour())
                .sportifs(courDto.getSportifsDtos().stream().map(this::toSportif).collect(Collectors.toSet()))
                .build();
    }

    public Sportif toSportif(SportifDto sportifDto) {
        return new Sportif.SportifBuilder()
                .id(sportifDto.getId())
                .nom(sportifDto.getNom())
                .prenom(sportifDto.getPrenom())
                .build();
    }

    public SportifDto toSportifDto(Sportif sportif) {
        return new SportifDto.SportifDtoBuilder()
                .id(sportif.getId())
                .nom(sportif.getNom())
                .prenom(sportif.getPrenom())
                .build();
    }
}
