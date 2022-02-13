package com.example.offf.hexagon.infrastructure.rest;

import com.example.offf.hexagon.infrastructure.rest.dto.CourDto;
import com.example.offf.hexagon.domain.model.Cour;
import com.example.offf.hexagon.domain.usecases.CoursManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private CourDto toCourDto(Cour cour) {
        return new CourDto.CourDtoBuilder()
                .id(cour.getId())
                .typeDeCours(cour.getTypeDeCours())
                .dateDuCours(cour.getDateDuCours())
                .build();
    }

    private Cour toCour(CourDto courDto) {
        return new Cour.CourBuilder()
        .id(courDto.getId())
        .typeDeCours(courDto.getTypeDeCours())
        .dateDuCours(courDto.getDateDuCours())
        .build();
    }
}
