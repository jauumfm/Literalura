package com.example.Literalura.repositorio;

import com.example.Literalura.model.Autor;
import com.example.Literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("select a from Autor a where :ano < a.morte and :ano > a.nascimento")
    List<Autor> buscarAutorPorAno (int ano);
}
