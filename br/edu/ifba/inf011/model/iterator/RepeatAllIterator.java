package br.edu.ifba.inf011.model.iterator;

import java.util.Iterator;
import java.util.List;

import br.edu.ifba.inf011.model.PlaylistItem;

public class RepeatAllIterator implements Iterator<PlaylistItem> {

	int index;
	List<PlaylistItem> items;

	public RepeatAllIterator(List<PlaylistItem> items) {
		this.items = items;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public PlaylistItem next() {
		if (index >= items.size()) {
			index = 0;
		}
		return items.get(index);
	}
}
