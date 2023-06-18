package br.edu.ifba.inf011;

import java.io.IOException;
import java.util.Random;

import br.edu.ifba.inf011.model.iterator.Player;
import br.edu.ifba.inf011.model.iterator.PlayerMode;
import br.edu.ifba.inf011.model.composite.Playlist;
import br.edu.ifba.inf011.model.composite.PlaylistItem;
import br.edu.ifba.inf011.model.iterator.PlaylistIterator;
import br.edu.ifba.inf011.model.decorator.MusicaBase;
import br.edu.ifba.inf011.model.observer.PlayerListener;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

/* Concrete Observer: Observer pattern */
public class Aplicacao implements PlayerListener {

	private final Player player;

	public Aplicacao() {
		this.player = new Player();
		this.player.addListeners(this);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Aplicacao app = new Aplicacao();
//		app.musica();
		app.player();
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

	private void player() throws IOException, InterruptedException {

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

		player.addItem(playlist1);
		player.addItem(playlist2);
		player.addItem(musicaSomenteComNota);
		player.addItem(musicaComNotaLetraOriginal);

		PlaylistIterator iterator = player.createIterator();

		while (iterator.temProximo()) {

			PlaylistItem playlistItem = iterator.proximo();
			String content = playlistItem.execute();

			System.out.println(content);

			Thread.sleep(1000);
			int numero = new Random().nextInt(2,8);

			if (numero % 5 == 0){
				player.setMode(PlayerMode.RepeatAll);
				iterator = player.createIterator();
			}else if (numero % 7 == 0){
				player.setMode(PlayerMode.RandomMode);
				iterator = player.createIterator();
			}
		}
	}

	@Override
	public void onChangeMode() {
		System.out.printf("\n::::::::::::\nModo: %s, está ativado!\n", player.getMode());
	}
}
