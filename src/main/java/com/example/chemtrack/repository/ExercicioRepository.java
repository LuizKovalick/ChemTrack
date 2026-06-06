package com.example.chemtrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.chemtrack.model.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
}

