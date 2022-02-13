package com.example.offf.hexagon.infrastructure.rest;

import com.example.offf.hexagon.infrastructure.rest.dto.CourDto;
import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.usecases.CoursManagement;
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

    public CourController(CoursManagement coursManagement) {
        this.coursManagement = coursManagement;
    }

    @PostMapping
    public ResponseEntity<CourDto> createCour(@RequestBody CourDto courDto) {
        Cour courCree = coursManagement.creerCour(toCour(courDto));
        CourDto courDtoCree = toCourDto(courCree);
        return new ResponseEntity(courDtoCree, HttpStatus.OK);
    }

    @GetMapping("cours")
    public ResponseEntity<List<CourDto>> getAllCours() {
        List<Cour> cours = coursManagement.recupereTousLesCours();
        List<CourDto> coursDto = cours.stream()
                .map(this::toCourDto)
                .collect(Collectors.toList());
        return new ResponseEntity(coursDto, HttpStatus.OK);
    }

    private CourDto toCourDto(Cour cour) {
        return new CourDto.CourDtoBuilder()
                .id(cour.getId())
                .typeDeCour(cour.getTypeDeCours())
                .dateDuCour(cour.getDateDuCours())
                .build();
    }

    private Cour toCour(CourDto courDto) {
        return new Cour.CourBuilder()
        .id(courDto.getId())
        .typeDeCours(courDto.getTypeDeCour())
        .dateDuCours(courDto.getDateDuCour())
        .build();
    }
}
