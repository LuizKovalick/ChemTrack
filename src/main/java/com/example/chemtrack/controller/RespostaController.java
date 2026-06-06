package com.example.chemtrack.controller;

import com.example.chemtrack.model.Resposta;
import com.example.chemtrack.service.RespostaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    private final RespostaService respostaService;

    public RespostaController(RespostaService respostaService) {
        this.respostaService = respostaService;
    }

    @GetMapping
    public List<Resposta> listarTodas() {
        return respostaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resposta> buscarPorId(@PathVariable Long id) {
        return respostaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Resposta salvar(@RequestBody Resposta resposta) {
        return respostaService.salvar(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        respostaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
