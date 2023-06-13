package br.edu.ifba.inf011;

import java.io.IOException;

import br.edu.ifba.inf011.model.*;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class Aplicacao{


	private void musica() throws IOException {

		ResourceLoader.DIR_NAME = "C:\\Users\\luissant\\OneDrive - BRQ\\Documentos\\Project\\design-patterns-music\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";

		Musica musica1 = new MusicaTemplate("GodSaveTheQueen");
		Musica musica2 = new MusicaTemplate("AndreaDorea");

		Musica musicaComNotaELetraOriginal =
				new MusicaNotas(
						new MusicaLetraOriginal(
							musica1, musica1.getNome()
						), musica1.getNome()
				);

		Musica musicaSomenteComNota =
				new MusicaNotas(musica2, musica2.getNome());

		Musica musicaComNotaELetraOriginalETraduzida =
				new MusicaNotas(
						new MusicaLetraOriginal(
								new MusicaLetraTraduzida(
										musica1,
										musica1.getNome(),
										"pt"
								), musica1.getNome()
						), musica1.getNome()
				);

		Playlist playlist = new Playlist("Minha playlist");
		playlist.insert(musicaComNotaELetraOriginal);
		playlist.insert(musicaSomenteComNota);
		playlist.insert(musicaComNotaELetraOriginalETraduzida);
		System.out.println(playlist.execute());
	}


	private void teste() throws IOException {

		ResourceLoader.DIR_NAME = "C:\\Users\\luissant\\OneDrive - BRQ\\Documentos\\Project\\design-patterns-music\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";
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
