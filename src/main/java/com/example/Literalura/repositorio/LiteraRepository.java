package com.example.Literalura.repositorio;

import com.example.Literalura.model.Autor;
import com.example.Literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LiteraRepository extends JpaRepository<Livro, Long> {



    @Query("SELECT a FROM Autor a WHERE LOWER(a.autor) = LOWER(?1)")
    Autor buscaAutor(String autor);

    @Query("select l from Livro l WHERE l.linguas IN :lingua ")
    List<Livro> buscarLivrosPorIdioma(List<String> lingua);

    @Query("SELECT n FROM Livro n WHERE LOWER(n.titulo) = LOWER(?1)")
    List<Livro> buscarLivros(String nome);
}
