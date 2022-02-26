package com.example.offf.hexagon.infrastructure.rest;

import com.example.offf.hexagon.domain.usecases.Reservation;
import com.example.offf.hexagon.infrastructure.rest.dto.CourDto;
import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.usecases.CoursManagement;
import com.example.offf.hexagon.infrastructure.rest.dto.DtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/cour")
public class CourController {

    private CoursManagement coursManagement;
    private Reservation reservation;
    private DtoMapper dtoMapper;

    public CourController(CoursManagement coursManagement, Reservation reservation, DtoMapper dtoMapper) {
        this.coursManagement = coursManagement;
        this.reservation = reservation;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping
    public ResponseEntity<CourDto> createCour(@RequestBody CourDto courDto) {
        Cour courCree = coursManagement.creerCour(dtoMapper.toCour(courDto));
        CourDto courDtoCree = dtoMapper.toCourDto(courCree);
        return new ResponseEntity(courDtoCree, HttpStatus.OK);
    }

    @PostMapping("/sportif")
    public ResponseEntity<CourDto> addSportifToCour(@RequestBody CourDto courDto) {
        Cour courMisAJour= reservation.reserveCours(dtoMapper.toCour(courDto)).get();
        CourDto courDtoMisAJour = dtoMapper.toCourDto(courMisAJour);
        return new ResponseEntity(courDtoMisAJour, HttpStatus.OK);
    }

    @GetMapping("cours")
    public ResponseEntity<List<CourDto>> getAllCours() {
        List<Cour> cours = coursManagement.recupereTousLesCours();
        List<CourDto> coursDto = cours.stream()
                .map(cour -> dtoMapper.toCourDto(cour))
                .collect(Collectors.toList());
        return new ResponseEntity(coursDto, HttpStatus.OK);
    }


}
