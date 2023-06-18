package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.PlaylistItem;

/* Aggregate: Iterator pattern */
public interface PlayerIterable {
	void addItem(PlaylistItem item);
	void removeItem(PlaylistItem item);
	PlaylistIterator createIterator();
}
