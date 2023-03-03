package com.mishop.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mishop.main.model.FileData;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileData,Integer> {
    Optional<FileData> findByName(String fileName);
}