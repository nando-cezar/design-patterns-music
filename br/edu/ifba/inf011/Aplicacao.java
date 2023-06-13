package br.edu.ifba.inf011;

import java.io.IOException;

import br.edu.ifba.inf011.model.*;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class Aplicacao{


	private void musica() throws IOException {

		var resource = ResourceLoader.instance();
		Musica musicaComNotaLetraOriginal = resource.createMusicaComNotaLetra("AndreaDorea");
		Musica musicaComNotaLetraOriginalTraduzida = resource.createMusicaComNotaLetraOriginalTraduzida("GodSaveTheQueen", "pt");
		Musica musicaSomenteComNota = resource.createMusicaSomenteComNota("GodSaveTheQueen");

		Playlist playlist1 = new Playlist("Minha playlist 1");
		playlist1.insert(musicaSomenteComNota);
		playlist1.insert(musicaComNotaLetraOriginalTraduzida);

		Playlist playlist2 = new Playlist("Minha playlist 2");
		playlist2.insert(musicaComNotaLetraOriginal);

		playlist1.insert(playlist2);

		System.out.println(playlist1.execute());
	}


	private void teste() throws IOException {

		Player player = new Player();
		int iCount = 0;

		//......

		while(player.temProximo() && iCount < 30) {
			System.out.println(player.proximo());
			iCount++;
		}

	}

	public static void main(String[] args) throws IOException{
		Aplicacao app = new Aplicacao();
		app.musica();
		//app.teste();
	}

}
