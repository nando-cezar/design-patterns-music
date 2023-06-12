package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

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

	public String getNome() {
		return this.nome;
	}

	public String randomize() {
		return null;
	}

	public String execute() {
		return null;
	}

}
