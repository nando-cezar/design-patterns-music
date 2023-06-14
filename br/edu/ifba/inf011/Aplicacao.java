package br.edu.ifba.inf011;

import java.io.IOException;
import java.util.Iterator;

import br.edu.ifba.inf011.model.Player;
import br.edu.ifba.inf011.model.Playlist;
import br.edu.ifba.inf011.model.PlaylistItem;
import br.edu.ifba.inf011.model.decorator.MusicaBase;
import br.edu.ifba.inf011.model.iterator.PlayerMode;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class Aplicacao {

	public static void main(String[] args) throws IOException, InterruptedException {
		Aplicacao app = new Aplicacao();
//		app.musica();
		app.teste();
	}

	private void musica() throws IOException {

		var resource = ResourceLoader.instance();
		MusicaBase musicaComNotaLetraOriginal = resource.createMusicaComNotaLetra("AndreaDorea");
		MusicaBase musicaComNotaLetraOriginalTraduzida = resource.createMusicaComNotaLetraOriginalTraduzida(
				"GodSaveTheQueen", "pt");
		MusicaBase musicaSomenteComNota = resource.createMusicaSomenteComNota("GodSaveTheQueen");

		Playlist playlist1 = new Playlist("Minha playlist 1");
		playlist1.insert(musicaSomenteComNota);
		playlist1.insert(musicaComNotaLetraOriginalTraduzida);

		Playlist playlist2 = new Playlist("Minha playlist 2");
		playlist2.insert(musicaComNotaLetraOriginal);

		playlist1.insert(playlist2);

		System.out.println(playlist1.execute());
	}

	private void teste() throws IOException, InterruptedException {

		var resource = ResourceLoader.instance();
		MusicaBase musicaComNotaLetraOriginal = resource.createMusicaComNotaLetra("AndreaDorea");
		MusicaBase musicaComNotaLetraOriginalTraduzida = resource.createMusicaComNotaLetraOriginalTraduzida(
				"GodSaveTheQueen", "pt");
		MusicaBase musicaSomenteComNota = resource.createMusicaSomenteComNota("GodSaveTheQueen");

		Playlist playlist1 = new Playlist("Minha playlist 1");
		playlist1.insert(musicaSomenteComNota);
		playlist1.insert(musicaComNotaLetraOriginalTraduzida);

		Playlist playlist2 = new Playlist("Minha playlist 2");
		playlist2.insert(musicaComNotaLetraOriginal);

		playlist1.insert(playlist2);

		Player player = new Player();
		player.addListeners(mode -> System.out.printf("Mudei para o modo %s", mode.toString()));
		player.setMode(PlayerMode.RepeatAll);
		player.insert(playlist1);
		player.insert(musicaSomenteComNota);
		player.insert(musicaComNotaLetraOriginal);
		Iterator<PlaylistItem> iterator = player.iterator();

		while (iterator.hasNext()) {
			PlaylistItem playlistItem = iterator.next();
			String content = playlistItem.execute();
			System.out.println(content);
			Thread.sleep(1000);
		}


	}

}
