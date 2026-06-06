package com.example.chemtrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.chemtrack.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmailAndSenha(String email, String senha);
}

