package com.example.offf.configuration;

import com.example.offf.domain.port.primary.GestionCours;
import com.example.offf.domain.port.secondary.CourAdapter;
import com.example.offf.domain.usecases.CoursManagement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationApp {

    private CourAdapter courAdapter;

    public ConfigurationApp(CourAdapter courAdapter) {
        this.courAdapter = courAdapter;
    }

    @Bean
    public CoursManagement coursManagement() {return new GestionCours(courAdapter);}
}
