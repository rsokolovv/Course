package com.example.sokolovswebapp.repositories;

import com.example.sokolovswebapp.models.Events;
import org.springframework.data.repository.CrudRepository;

public interface EventsInterface extends CrudRepository<Events, Long> {
}
