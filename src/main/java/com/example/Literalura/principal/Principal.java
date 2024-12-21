package com.example.Literalura.principal;

import com.example.Literalura.model.*;
import com.example.Literalura.repositorio.AutorRepository;
import com.example.Literalura.repositorio.LiteraRepository;
import com.example.Literalura.service.ConsumoApi;
import com.example.Literalura.service.ConverteDados;
import com.example.Literalura.service.IConverteDados;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Principal {
    private ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO = "http://gutendex.com/books/?search=";
    private Scanner leitura = new Scanner(System.in);
    private ConverteDados conversor = new ConverteDados();
    private LiteraRepository repositorio;
    private AutorRepository autorRepository;

    public Principal(LiteraRepository repositorio, AutorRepository autorRepository) {
        this.repositorio = repositorio;
        this.autorRepository = autorRepository;
    }

    public void exibeMenu() {
        var opcao = -1;
        while(opcao != 0) {
            var menu = """
                    1 - Buscar livro pelo titulo
                    2 - Listar livros registrados
                    3 - Listar autores resgistrados
                    4 - Listar autores vivos em um determiando ano
                    5 - Listar livros em um determinado idioma
                                                
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarTitulo();
                    break;
                case 2:
                    buscarLivros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    buscarAutoresVivosEmAno();
                    break;
                case 5:
                    buscarLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }

    private DadosResult getDadosResult(){
        System.out.println("Qual titulo deseja para buscar?");
        var titulo = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO+titulo.replace(" ", "%20"));
        DadosResult dados = conversor.obterDados(json, DadosResult.class);
        return dados;
    }

    private void buscarTitulo(){
        DadosResult dados = getDadosResult();
        List<DadosLivro> livros = new ArrayList<>(dados.livros());
        List<Livro> listaDeLivros = livros.stream()
                .map(Livro::new)
                .collect(Collectors.toList());
        Livro livro = listaDeLivros.get(0);
        System.out.println(livro);
        Autor autor = buscarAutor(livro.getAutor().getAutor());
        if (autor != null){
            livro.setAutor(autor);
        }
        repositorio.save(livro);
    }

    private void buscarLivros(){
        List<Livro> registrados = repositorio.findAll();
        registrados.forEach(System.out::println);
    }

    private void listarAutores() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }

    private void buscarAutoresVivosEmAno() {
        System.out.println("Qual ano vc deseja?");
        var ano = leitura.nextInt();
        List<Autor> vivos = autorRepository.buscarAutorPorAno(ano);
        if (vivos.isEmpty()){
            System.out.println("Nao tem (no nosso banco) autor vivo nesse ano");
        }else {
            vivos.forEach(System.out::println);
        }
    }

//    private void buscarLivros() {
//        System.out.println("Qual livro deseja para buscar?");
//        var nome = leitura.nextLine();
//        List<Livro> livros = repositorio.buscarLivros(nome);
//        livros.forEach(System.out::println);
//    }

    private void buscarLivrosPorIdioma(){
        System.out.println("Qual lingua deseja para buscar?");
        var lingua = leitura.nextLine();
        List<Livro> livros = repositorio.buscarLivrosPorIdioma(List.of(lingua));
        if (livros.isEmpty()){
            System.out.println("Nao tem livros");
        }else {
        livros.forEach(System.out::println);
        }
    }

    private Autor buscarAutor(String autor){
        return repositorio.buscaAutor(autor);
    }



}
