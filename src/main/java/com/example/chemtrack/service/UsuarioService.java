package com.example.chemtrack.service;

import com.example.chemtrack.model.Usuario;
import com.example.chemtrack.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarPorPontos() {
        return usuarioRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Usuario::getPontos).reversed())
                .collect(Collectors.toList());
    }

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
    }

    public Usuario atualizar(Usuario usuario) {
        Usuario existente = buscarPorId(usuario.getId());
        existente.setNome(usuario.getNome());
        existente.setEmail(usuario.getEmail());
        existente.setSenha(usuario.getSenha());
        return usuarioRepository.save(existente);
    }
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
