package com.example.chemtrack.service;

import com.example.chemtrack.model.Exercicio;
import com.example.chemtrack.repository.ExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public List<Exercicio> listarTodos() {
        return exercicioRepository.findAll();
    }

    public Exercicio buscarPorId(Long id) {
        return exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado com ID: " + id));
    }

    public Exercicio salvar(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    public void deletar(Long id) {
        exercicioRepository.deleteById(id);
    }
}
