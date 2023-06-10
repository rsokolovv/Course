package com.example.sokolovswebapp.repositories;

import com.example.sokolovswebapp.models.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsInterface extends CrudRepository<News, Long> {

}
