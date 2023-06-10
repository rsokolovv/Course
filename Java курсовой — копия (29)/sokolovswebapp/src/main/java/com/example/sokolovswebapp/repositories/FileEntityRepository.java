package com.example.sokolovswebapp.repositories;

import com.example.sokolovswebapp.models.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileEntityRepository extends JpaRepository<FileEntity, Long> {
}