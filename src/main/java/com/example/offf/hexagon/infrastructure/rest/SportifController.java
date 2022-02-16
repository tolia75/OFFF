package com.example.offf.hexagon.infrastructure.rest;

import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.domain.usecases.SportifManagement;
import com.example.offf.hexagon.infrastructure.rest.dto.SportifDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportifController {

    private SportifManagement sportifManagement;

    public SportifController(SportifManagement sportifManagement) {
        this.sportifManagement = sportifManagement;
    }

    @PostMapping("/sportif")
    public ResponseEntity<SportifDto> createSportif(@RequestBody SportifDto sportifDto) {
        Sportif sportif = sportifManagement.createSportif(toSportif(sportifDto)).get();
        return new ResponseEntity(toSportifDto(sportif), HttpStatus.OK);
    }

    private Sportif toSportif(SportifDto sportifDto) {
        return new Sportif.SportifBuilder()
                .id(sportifDto.getId())
                .nom(sportifDto.getNom())
                .prenom(sportifDto.getPrenom())
                .build();
    }

    private SportifDto toSportifDto(Sportif sportif) {
        return new SportifDto.SportifDtoBuilder()
                .id(sportif.getId())
                .nom(sportif.getNom())
                .prenom(sportif.getPrenom())
                .build();
    }

}
