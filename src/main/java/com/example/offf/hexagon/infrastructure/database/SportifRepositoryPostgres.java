package com.example.offf.hexagon.infrastructure.database;

import com.example.offf.hexagon.infrastructure.database.dao.SportifDao;
import org.springframework.data.repository.CrudRepository;

public interface SportifRepositoryPostgres extends CrudRepository<SportifDao, Long> {
}
