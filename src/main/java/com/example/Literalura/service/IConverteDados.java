package com.example.Literalura.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
