package com.example.Literalura.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity/*comunicacao com BD*/
@Table(name = "autor")/*criando tabela series*/

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String autor;
    private Integer morte;
    private Integer nascimento;
    @OneToMany(mappedBy = "autor",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();

    public Autor() {
    }

    public Autor(DadosAutor dadosAutor) {
        this.autor=dadosAutor.autor();
        this.morte=dadosAutor.morte();
        this.nascimento=dadosAutor.nascimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Livro> getLivro() {
        return livros;
    }

//    public void setLivro(List<Livro> livros) {
//        this.livros = livros;
//        livros.forEach(e -> e.setAutor(String.valueOf(this)));/*esse comando e para ter uma interacao
//        reversa e falando para o episodio a qual serie ele pertence*/
//    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getMorte() {
        return morte;
    }

    public void setMorte(Integer morte) {
        this.morte = morte;
    }

    public Integer getNascimento() {
        return nascimento;
    }

    public void setNascimento(Integer nascimento) {
        this.nascimento = nascimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "  nascimento: " + nascimento + ",\n" +
                "  morte: " + morte + ",\n" +
                "  nome: '" + autor;
    }

}
