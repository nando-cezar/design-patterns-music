package br.edu.ifba.inf011;

import java.io.IOException;

import br.edu.ifba.inf011.model.*;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class Aplicacao{


	private void musica() throws IOException {

		ResourceLoader.DIR_NAME = "C:\\Users\\luissant\\OneDrive - BRQ\\Documentos\\Project\\design-patterns-music\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";

		Musica template = new MusicaTemplate("GodSaveTheQueen");
		Musica template2 = new MusicaTemplate("AndreaDorea");

		Musica musica_ =
				new MusicaNotas(
						new MusicaLetraOriginal(
										template,
										template.getNome()
						), template.getNome()
				);

		PlaylistItem musica2 = new MusicaNotas(musica_, "AndreaDorea");

		PlaylistItem musica =
				new MusicaNotas(
						new MusicaLetraOriginal(
								new MusicaLetraTraduzida(
										template,
										template.getNome(),
										"pt"
								), template.getNome()
						), template.getNome()
				);

				Playlist playlist = new Playlist("Minha playlist");
				playlist.insert(musica);
				playlist.insert(musica2);
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
