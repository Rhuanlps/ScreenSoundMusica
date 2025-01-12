package br.com.alura.screenSoundMusica;

import br.com.alura.screenSoundMusica.principal.Principal;
import br.com.alura.screenSoundMusica.repository.ArtistaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenSoundMusicaApplication implements CommandLineRunner {

	ArtistaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ScreenSoundMusicaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);

	principal.exibirMenu();
	}
}
