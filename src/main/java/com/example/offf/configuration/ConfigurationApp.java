package com.example.offf.configuration;

import com.example.offf.hexagon.domain.port.primary.GestionCours;
import com.example.offf.hexagon.domain.port.primary.GestionSportif;
import com.example.offf.hexagon.domain.port.primary.ReservationImpl;
import com.example.offf.hexagon.domain.port.secondary.CourAdapter;
import com.example.offf.hexagon.domain.port.secondary.SportifAdapter;
import com.example.offf.hexagon.domain.usecases.CoursManagement;
import com.example.offf.hexagon.domain.usecases.Reservation;
import com.example.offf.hexagon.domain.usecases.SportifManagement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationApp {

    private CourAdapter courAdapter;
    private SportifAdapter sportifAdapter;

    public ConfigurationApp(CourAdapter courAdapter, SportifAdapter sportifAdapter) {
        this.courAdapter = courAdapter;
        this.sportifAdapter = sportifAdapter;
    }

    @Bean
    public CoursManagement coursManagement() {return new GestionCours(courAdapter);}

    @Bean
    public SportifManagement sportifManagement() {return new GestionSportif(sportifAdapter);}

    @Bean
    public Reservation reservation() {return new ReservationImpl(courAdapter);}
}
