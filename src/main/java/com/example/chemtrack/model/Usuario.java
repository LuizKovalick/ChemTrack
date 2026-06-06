package com.example.chemtrack.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    private Integer pontos = 0;
    private int nivel;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Resposta> respostas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<InsigniaConquistada> insignias = new ArrayList<>();
    
    
    
	public Usuario(Long id, String nome, String email, String senha, Integer pontos, int nivel, List<Resposta> respostas,
			List<InsigniaConquistada> insignias) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.pontos = pontos;
		this.nivel = nivel;
		this.respostas = respostas;
		this.insignias = insignias;
	}
	
	public Usuario() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public List<InsigniaConquistada> getInsignias() {
		return insignias;
	}

	public void setInsignias(List<InsigniaConquistada> insignias) {
		this.insignias = insignias;
	}

}
