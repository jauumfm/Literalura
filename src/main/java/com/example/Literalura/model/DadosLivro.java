package com.example.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.logging.log4j.util.Strings;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("title") String titulo,
                         @JsonAlias("authors")List<DadosAutor> autor,/*Lista de autor pois tem {}*/
                         @JsonAlias("languages") List<String> linguas,/*lingua é string pois nao tem {}*/
                         @JsonAlias("download_count") Integer download
                        )
{

    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public Integer download() {
        return download;
    }

    @Override
    public List<String> linguas() {
        return linguas;
    }
}
