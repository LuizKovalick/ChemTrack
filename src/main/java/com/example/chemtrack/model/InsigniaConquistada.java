package com.example.chemtrack.model;

import jakarta.persistence.*;

@Entity
public class InsigniaConquistada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Insignia insignia;

    private String dataConquista;

	public InsigniaConquistada(Long id, Usuario usuario, Insignia insignia, String dataConquista) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.insignia = insignia;
		this.dataConquista = dataConquista;
	}

	public InsigniaConquistada() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Insignia getInsignia() {
		return insignia;
	}

	public void setInsignia(Insignia insignia) {
		this.insignia = insignia;
	}

	public String getDataConquista() {
		return dataConquista;
	}

	public void setDataConquista(String dataConquista) {
		this.dataConquista = dataConquista;
	}

}
