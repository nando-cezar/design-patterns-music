package br.edu.ifba.inf011.model.resources;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.MusicaNome;
import br.edu.ifba.inf011.model.decorator.MusicaBase;
import br.edu.ifba.inf011.model.decorator.MusicaLetraOriginal;
import br.edu.ifba.inf011.model.decorator.MusicaLetraTraduzida;
import br.edu.ifba.inf011.model.decorator.MusicaNotas;

public class ResourceLoader {

	private static final String DIR_NAME =
			System.getProperty("user.dir") + "\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";

	private static ResourceLoader loader = null;

	public static ResourceLoader instance() {
		if (ResourceLoader.loader == null) {
			ResourceLoader.loader = new ResourceLoader();
		}
		return ResourceLoader.loader;

	}

	public MusicaBase createMusicaSomenteComNota(String nome) throws IOException {
		Musica musica = new MusicaNome(nome);
		MusicaNotas musicaSomenteComNota = new MusicaNotas(musica);
		return musicaSomenteComNota;
	}

	public MusicaBase createMusicaComNotaLetra(String nome) throws IOException {
		Musica musica = new MusicaNome(nome);
		MusicaNotas musicaComNotaLetra = new MusicaNotas(musica);
		MusicaLetraOriginal musicaLetraOriginal = new MusicaLetraOriginal(musicaComNotaLetra);
		return musicaLetraOriginal;
	}

	public MusicaBase createMusicaComNotaLetraOriginalTraduzida(String nome, String extensao)
			throws IOException {
		Musica musica = new MusicaNome(nome);
		MusicaNotas musicaComNotaLetraOriginalTraduzida = new MusicaNotas(musica);
		MusicaLetraOriginal musicaLetraOriginal = new MusicaLetraOriginal(
				musicaComNotaLetraOriginalTraduzida);

		return new MusicaLetraTraduzida(musicaLetraOriginal, "pt");
	}

	public List<String> loadNotas(String nome) throws IOException {
		return this.loadResource(nome, "notas");
	}

	public List<String> loadLetra(String nome) throws IOException {
		return this.loadResource(nome, "letra");
	}

	public List<String> loadTraducao(String nome, String extensao) throws IOException {
		return this.loadResource(nome, extensao);
	}

	public List<String> loadResource(String nome, String extensao) throws IOException {
		List<String> resource = new ArrayList<>();
		Path path = Paths.get(ResourceLoader.DIR_NAME + nome + "." + extensao);
		Files
				.lines(path, StandardCharsets.ISO_8859_1)
				.forEach(resource::add);
		return resource;
	}

}
