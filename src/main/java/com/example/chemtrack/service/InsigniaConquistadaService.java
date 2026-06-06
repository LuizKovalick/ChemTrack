package com.example.chemtrack.service;

import com.example.chemtrack.model.InsigniaConquistada;
import com.example.chemtrack.repository.InsigniaConquistadaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsigniaConquistadaService {

    private final InsigniaConquistadaRepository repository;

    public InsigniaConquistadaService(InsigniaConquistadaRepository repository) {
        this.repository = repository;
    }

    public List<InsigniaConquistada> listarTodos() {
        return repository.findAll();
    }

    public Optional<InsigniaConquistada> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public InsigniaConquistada salvar(InsigniaConquistada ic) {
        return repository.save(ic);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
