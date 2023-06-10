package com.example.sokolovswebapp.repositories;

import com.example.sokolovswebapp.models.Teachers;
import org.springframework.data.repository.CrudRepository;

public interface TeachersInterface extends CrudRepository<Teachers, Long> {
}
