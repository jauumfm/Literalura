package com.example.Literalura.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosResult(@JsonAlias("results")List<DadosLivro> livros) {
    @Override
    public String toString() {
        return "livros=" + livros;
    }

    @Override
    public List<DadosLivro> livros() {
        return livros;
    }
}

