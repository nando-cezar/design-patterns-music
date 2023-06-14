package br.edu.ifba.inf011.model.iterator;

import java.util.Iterator;
import java.util.List;

import br.edu.ifba.inf011.model.PlaylistItem;

public class PlayAllIterator implements Iterator<PlaylistItem> {

	List<PlaylistItem> items;
	int index;

	public PlayAllIterator(List<PlaylistItem> items) {
		this.items = items;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		return index < items.size();
	}

	@Override
	public PlaylistItem next() {
		if (hasNext()) {
			return items.get(index++);
		}
		return null;
	}

}
