package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

/* Composite: Composite pattern */
public class Playlist implements PlaylistItem {

	private final String nome;
	private final List<PlaylistItem> items;

	public Playlist(String nome) {
		this.nome = nome;
		this.items = new ArrayList<>();
	}

	public void insert(PlaylistItem item) {
		this.items.add(item);
	}

	public void remove(PlaylistItem item) {
		this.items.remove(item);
	}

	public List<PlaylistItem> getChildren(){
		return this.items;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	public String randomize() {
		return null;
	}

	@Override
	public String execute() {
		System.out.println("Executando PLAYLIST");
		StringBuffer str = new StringBuffer();
		for (PlaylistItem item: items){
			str.append(item.execute());
		}
		return str.toString();
	}

}
