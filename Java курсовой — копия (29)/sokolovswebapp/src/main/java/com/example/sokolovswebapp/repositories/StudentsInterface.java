package com.example.sokolovswebapp.repositories;

import com.example.sokolovswebapp.models.Students;
import org.springframework.data.repository.CrudRepository;

public interface StudentsInterface extends CrudRepository<Students, Long> {
}
