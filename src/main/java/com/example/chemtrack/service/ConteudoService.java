package com.example.chemtrack.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.chemtrack.model.Conteudo;
import com.example.chemtrack.repository.ConteudoRepository;

@Service
public class ConteudoService {

    private final ConteudoRepository repository;

    public ConteudoService(ConteudoRepository repository) {
        this.repository = repository;
    }

    public List<Conteudo> listarTodos() {
        return repository.findAll();
    }

    public Conteudo salvar(Conteudo conteudo) {
        return repository.save(conteudo);
    }

    public Conteudo buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
