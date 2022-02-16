package com.example.offf.hexagon.infrastructure.database;

import com.example.offf.hexagon.domain.model.Sportif;
import org.springframework.data.repository.CrudRepository;

public interface SportifRepositoryPostgres extends CrudRepository<Sportif, Long> {
}
