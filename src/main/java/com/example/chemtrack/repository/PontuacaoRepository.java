package com.example.chemtrack.repository;

import com.example.chemtrack.model.Pontuacao;
import com.example.chemtrack.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PontuacaoRepository extends JpaRepository<Pontuacao, Long> {
    Optional<Pontuacao> findByUsuario(Usuario usuario);
}
