package com.example.offf.infrastructure.database;

import com.example.offf.infrastructure.database.dao.CourDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourRepositoryPostgres extends CrudRepository<CourDAO, Long> {

}
