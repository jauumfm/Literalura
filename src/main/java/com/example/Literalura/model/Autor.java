package com.example.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Autor(@JsonAlias("name")String autor,
                    @JsonAlias("birth_year")Integer nasciemnto,
                    @JsonAlias("death_year")Integer morte
                    )
{
}
