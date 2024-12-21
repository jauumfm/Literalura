package com.example.Literalura.model;

import jakarta.persistence.*;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;


@Entity/*comunicacao com BD*/
@Table(name = "livro")/*criando tabela series*/

public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)/*O bd e responsavel por gerar uma unica chave pra cada serie*/
    private long id;/*chave primaria*/
    private String titulo;
    @ManyToOne(fetch = FetchType.EAGER)
    private Autor autor;
    private List<String> linguas = new ArrayList<>();
    private Integer download;

    public Livro() {
    }

    public Livro(DadosLivro dadosLivro) {
        this.titulo=dadosLivro.titulo();
        this.linguas=dadosLivro.linguas();
        this.download= dadosLivro.download();
        this.autor = new Autor(dadosLivro.autor().get(0));
    }

//    public Livro(List<DadosAutor> autor, String titulo, List<String> linguas, Integer download) {
//        this.autor = titulo;
//    }

    public Long getId() {
        return id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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

    public Integer getDownload() {
        return download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }

    public List<String> getLinguas() {
        return linguas;
    }

    public void setLinguas(List<String> linguas) {
        this.linguas = linguas;
    }

    @Override
    public String toString() {
        return "título: '" + titulo + "',\n" +
                "  autor: '" + autor.getAutor() + "',\n" +
                "  nascimento: " + autor.getNascimento() + ",\n" +
                "  morte: " + autor.getMorte() + ",\n" +
                "  downloads: " + download + ",\n" +
                "  línguas: " + Strings.join(linguas, ',');
    }
}
