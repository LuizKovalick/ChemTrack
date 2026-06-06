package com.example.chemtrack.service;

import com.example.chemtrack.model.Insignia;
import com.example.chemtrack.repository.InsigniaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsigniaService {

    private final InsigniaRepository insigniaRepository;

    public InsigniaService(InsigniaRepository insigniaRepository) {
        this.insigniaRepository = insigniaRepository;
    }

    public List<Insignia> listarTodos() {
        return insigniaRepository.findAll();
    }

    public Optional<Insignia> buscarPorId(Long id) {
        return insigniaRepository.findById(id);
    }

    public Insignia salvar(Insignia insignia) {
        return insigniaRepository.save(insignia);
    }

    public void deletar(Long id) {
        insigniaRepository.deleteById(id);
    }
}
