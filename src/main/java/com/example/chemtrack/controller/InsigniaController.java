package com.example.chemtrack.controller;

import com.example.chemtrack.model.Insignia;
import com.example.chemtrack.service.InsigniaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insignias")
public class InsigniaController {

    private final InsigniaService insigniaService;

    public InsigniaController(InsigniaService insigniaService) {
        this.insigniaService = insigniaService;
    }

    @GetMapping
    public List<Insignia> listarTodas() {
        return insigniaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Insignia> buscarPorId(@PathVariable Long id) {
        return insigniaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Insignia salvar(@RequestBody Insignia insignia) {
        return insigniaService.salvar(insignia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        insigniaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
