package com.colors.repository;

import com.colors.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  ColorRepository extends JpaRepository<ColorEntity, Long> {

    Optional<ColorEntity> findByNameIgnoreCase(String name);
}
