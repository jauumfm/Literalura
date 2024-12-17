package com.example.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Livros(@JsonAlias("title") String nome,
                     @JsonAlias("authors")Autor autor,
                     @JsonAlias("languages") Linguas lingua,
                     @JsonAlias("download_count")Integer download
                     )
{

}
