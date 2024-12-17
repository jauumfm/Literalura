package com.example.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Linguas(@JsonAlias("langueges")String linguas) {
}
