package br.edu.ifba.inf011;

import java.io.IOException;

import br.edu.ifba.inf011.model.*;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class Aplicacao{


	private void musica() throws IOException {

		ResourceLoader.DIR_NAME = "C:\\Users\\luissant\\OneDrive - BRQ\\Documentos\\Project\\design-patterns-music\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";

		Musica template = new MusicaTemplate("GodSaveTheQueen");

		Musica musica =
				new MusicaLetraTraduzida(
						new MusicaLetraOriginal(
								new MusicaNotas(
										template,
										template.getNome()
								), template.getNome()
						), template.getNome(), "pt"
				);
		System.out.println(musica.execute());
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
