package com.example.offf.hexagon.infrastructure.rest;

import com.example.offf.hexagon.domain.model.Sportif;
import com.example.offf.hexagon.domain.usecases.SportifManagement;
import com.example.offf.hexagon.infrastructure.rest.dto.DtoMapper;
import com.example.offf.hexagon.infrastructure.rest.dto.SportifDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportifController {

    private SportifManagement sportifManagement;
    private DtoMapper dtoMapper;

    public SportifController(SportifManagement sportifManagement, DtoMapper dtoMapper) {
        this.sportifManagement = sportifManagement;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping("/sportif")
    public ResponseEntity<SportifDto> createSportif(@RequestBody SportifDto sportifDto) {
        Sportif sportif = sportifManagement.createSportif(dtoMapper.toSportif(sportifDto)).get();
        return new ResponseEntity(dtoMapper.toSportifDto(sportif), HttpStatus.OK);
    }



}
