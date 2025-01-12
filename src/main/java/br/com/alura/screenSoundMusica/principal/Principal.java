package br.com.alura.screenSoundMusica.principal;

import br.com.alura.screenSoundMusica.model.Artistas;
import br.com.alura.screenSoundMusica.model.Musica;
import br.com.alura.screenSoundMusica.model.TipoArtista;
import br.com.alura.screenSoundMusica.repository.ArtistaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final ArtistaRepository repository;
    Scanner leitura = new Scanner(System.in);

    public Principal(ArtistaRepository repository) {
        this.repository = repository;
    }

    public void exibirMenu() {

        var opcao = -1;

        while (opcao != 9) {
            var menu = """
                     Screen Sound Músicas 
                    
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                    
                    9 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }


    private void cadastrarArtistas() {
        var cadastrarNovo = "s";
        while (cadastrarNovo.equalsIgnoreCase("s"))

            System.out.println("Digite o nome do artista:");
        var nome = leitura.nextLine();

        System.out.println("Tipo do artista: (solo,dupla ou banda)");
        var tipo = leitura.nextLine();

        TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toLowerCase());
        Artistas artistas = new Artistas(nome, tipoArtista);
        repository.save(artistas);
        System.out.println("Cadastrar novo artista? (S/N)");
        cadastrarNovo = leitura.nextLine();

    }

    private void cadastrarMusicas() {
        System.out.println("Cadastrar musica de qual artista:");
        var nome = leitura.nextLine();

        Optional<Artistas> artistas = repository.findByNomeContainingIgnoreCase(nome);
        if (artistas.isPresent()) {
            System.out.println("Informe o titulo da música: ");
            var nomeMusica = leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artistas.get());
            repository.save(artistas.get());
        }
    }

        private void listarMusicas() {
            List<Artistas> artistasList = repository.findAll();
            artistasList.forEach(System.out::println);

        }

        private void buscarMusicasPorArtista() {
            System.out.println("Buscas músicas de que artista?");
            var nome = leitura.nextLine();
            List<Musica> musicas = repository.buscaMusicaPorArtista(nome);
            musicas.forEach(System.out::println);
        }

        private void pesquisarDadosDoArtista() {
        }
    }