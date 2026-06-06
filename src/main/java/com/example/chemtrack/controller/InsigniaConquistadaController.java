package com.example.chemtrack.controller;

import com.example.chemtrack.model.InsigniaConquistada;
import com.example.chemtrack.service.InsigniaConquistadaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insignias-conquistadas")
public class InsigniaConquistadaController {

    private final InsigniaConquistadaService service;

    public InsigniaConquistadaController(InsigniaConquistadaService service) {
        this.service = service;
    }

    @GetMapping
    public List<InsigniaConquistada> listarTodas() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsigniaConquistada> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InsigniaConquistada salvar(@RequestBody InsigniaConquistada ic) {
        return service.salvar(ic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
