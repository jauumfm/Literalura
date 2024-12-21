package com.example.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosAutor(@JsonAlias("name")String autor,
                         @JsonAlias("birth_year")Integer nascimento,
                         @JsonAlias("death_year")Integer morte
                    )
{
    @Override
    public String autor() {
        return autor;
    }

    @Override
    public Integer morte() {
        return morte;
    }

    @Override
    public Integer nascimento() {
        return nascimento;
    }

    @Override
    public String toString() {
        return "autor='" + autor + '\'' +
                ", nascimento=" + nascimento +
                ", morte=" + morte;
    }
}
