package com.example.chemtrack.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.chemtrack.model.Conteudo;

public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {

	List<Conteudo> findAll();
}

