package com.example.offf.hexagon.infrastructure.database;

import com.example.offf.hexagon.infrastructure.database.dao.CourDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourRepositoryPostgres extends CrudRepository<CourDAO, Long> {

}
