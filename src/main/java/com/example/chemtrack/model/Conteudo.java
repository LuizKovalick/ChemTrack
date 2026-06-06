package com.example.chemtrack.model;

import jakarta.persistence.*;

@Entity
public class Conteudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    @Lob
    private String texto;
    private String urlPdf;
    private String urlVideo;

    
    public Conteudo() {}

    public Conteudo(String titulo, String texto, String urlPdf, String urlVideo) {
        this.titulo = titulo;
        this.texto = texto;
        this.urlPdf = urlPdf;
        this.urlVideo = urlVideo;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUrlPdf() {
        return urlPdf;
    }

    public void setUrlPdf(String urlPdf) {
        this.urlPdf = urlPdf;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }
}