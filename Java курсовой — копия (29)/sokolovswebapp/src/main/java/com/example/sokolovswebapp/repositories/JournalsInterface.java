package com.example.sokolovswebapp.repositories;

import com.example.sokolovswebapp.models.Journals;
import org.springframework.data.repository.CrudRepository;

public interface JournalsInterface extends CrudRepository<Journals, Long> {
    void findByRfiost(String rfiost);
}
