<!DOCTYPE html>
<html lang="pt-BR">
<body>
    <header>
        <h1>Literalura</h1>
        <p>Descubra, registre e explore o mundo da literatura</p>
    </header>
    <main>
        <div class="container">
            <section>
                <h2>Descrição</h2>
                <p>
                    O projeto <strong>Literalura</strong> é uma aplicação Java que conecta-se a APIs para buscar, 
                    processar e armazenar informações sobre livros e autores. 
                    Com ele, você pode explorar dados literários como títulos, idiomas e informações sobre autores.
                </p>
            </section>
            <section>
                <h2>Funcionalidades</h2>
                <ul>
                    <li><strong>Buscar livro pelo título:</strong> Pesquise um título em uma API externa e registre-o no banco de dados.</li>
                    <li><strong>Listar livros registrados:</strong> Consulte todos os livros já cadastrados.</li>
                    <li><strong>Listar autores registrados:</strong> Veja a lista de autores no banco de dados.</li>
                    <li><strong>Listar autores vivos em um ano específico:</strong> Descubra quais autores estavam vivos em determinado ano.</li>
                    <li><strong>Listar livros por idioma:</strong> Filtre os livros cadastrados pelo idioma.</li>
                </ul>
            </section>
            <section>
                <h2>Estrutura do Menu</h2>
                <p>
                    Ao executar a aplicação, você verá o seguinte menu interativo:
                </p>
                <pre>
1 - Buscar livro pelo título
2 - Listar livros registrados
3 - Listar autores registrados
4 - Listar autores vivos em um determinado ano
5 - Listar livros em um determinado idioma

0 - Sair
                </pre>
            </section>
            <section>
                <h2>Estrutura do Projeto</h2>
                <ul>
                    <li><strong>Pacote <code>model</code>:</strong> Contém as classes que representam os dados, como <code>Livro</code> e <code>Autor</code>.</li>
                    <li><strong>Pacote <code>repositorio</code>:</strong> Interfaces para comunicação com o banco de dados.</li>
                    <li><strong>Pacote <code>service</code>:</strong> Serviços para consumo de API e conversão de dados.</li>
                    <li><strong>Pacote <code>principal</code>:</strong> Contém a classe principal responsável pelo fluxo da aplicação.</li>
                </ul>
            </section>
            <section>
                <h2>Possíveis Melhorias</h2>
                <p>A aplicação pode ser aprimorada com as seguintes ideias:</p>
                <ul>
                    <li>Adicionar validações mais robustas e mensagens de erro detalhadas.</li>
                    <li>Implementar paginação para exibição de grandes volumes de dados.</li>
                    <li>Incluir testes unitários para garantir a qualidade do código.</li>
                    <li>Expandir o suporte para novas APIs literárias.</li>
                </ul>
            </section>
        </div>
    </main>
</body>
</html>
