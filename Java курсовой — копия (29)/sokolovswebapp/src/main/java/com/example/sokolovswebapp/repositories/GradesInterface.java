package com.example.sokolovswebapp.repositories;

import com.example.sokolovswebapp.models.Grades;
import org.springframework.data.repository.CrudRepository;

public interface GradesInterface extends CrudRepository<Grades, Long> {
}
