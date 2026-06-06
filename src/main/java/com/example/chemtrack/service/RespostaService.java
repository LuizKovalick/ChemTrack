package com.example.chemtrack.service;

import com.example.chemtrack.model.Resposta;
import com.example.chemtrack.repository.RespostaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespostaService {

    private final RespostaRepository respostaRepository;

    public RespostaService(RespostaRepository respostaRepository) {
        this.respostaRepository = respostaRepository;
    }

    public List<Resposta> listarTodos() {
        return respostaRepository.findAll();
    }

    public Optional<Resposta> buscarPorId(Long id) {
        return respostaRepository.findById(id);
    }

    public Resposta salvar(Resposta resposta) {
        return respostaRepository.save(resposta);
    }

    public void deletar(Long id) {
        respostaRepository.deleteById(id);
    }
}
