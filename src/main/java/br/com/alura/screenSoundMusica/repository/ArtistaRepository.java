package br.com.alura.screenSoundMusica.repository;

import br.com.alura.screenSoundMusica.model.Artistas;
import br.com.alura.screenSoundMusica.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artistas,Long> {

    Optional<Artistas> findByNomeContainingIgnoreCase(String nome);

    List<Musica> buscaMusicaPorArtista(String nome);
}
