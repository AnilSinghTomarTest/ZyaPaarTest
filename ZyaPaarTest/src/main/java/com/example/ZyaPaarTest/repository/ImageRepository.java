package com.example.ZyaPaarTest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ZyaPaarTest.entities.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Integer>{
	
	Optional<ImageEntity> findById(int fileName);
	Optional<ImageEntity> findByName(String fileName);
}
