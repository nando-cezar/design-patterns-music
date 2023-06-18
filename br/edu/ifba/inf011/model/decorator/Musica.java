package br.edu.ifba.inf011.model.decorator;

import br.edu.ifba.inf011.model.composite.PlaylistItem;

/* Component: Decorator pattern */
public interface Musica extends PlaylistItem {

	void reset();

	Boolean finish();

	String play();
}
