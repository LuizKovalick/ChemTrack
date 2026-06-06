package com.example.chemtrack.model;


import jakarta.persistence.*;

@Entity
public class Insignia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private int pontosNecessarios;
	public Insignia(Long id, String nome, String descricao, int pontosNecessarios) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.pontosNecessarios = pontosNecessarios;
	}
	public Insignia() {
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getPontosNecessarios() {
		return pontosNecessarios;
	}
	public void setPontosNecessarios(int pontosNecessarios) {
		this.pontosNecessarios = pontosNecessarios;
	}
	
}

