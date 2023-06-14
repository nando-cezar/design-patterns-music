package br.edu.ifba.inf011.model;

public interface Musica extends PlaylistItem {

	void reset();

	Boolean finish();

	String play();
}
