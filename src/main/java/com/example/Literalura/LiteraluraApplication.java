package com.example.Literalura;

import com.example.Literalura.model.Autor;
import com.example.Literalura.principal.Principal;
import com.example.Literalura.repositorio.AutorRepository;
import com.example.Literalura.repositorio.LiteraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LiteraRepository repositorio;
	@Autowired
	private AutorRepository autorRepositorio;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio,autorRepositorio);
		principal.exibeMenu();
	}

}
