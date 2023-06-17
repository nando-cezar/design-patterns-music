package br.edu.ifba.inf011.model.iterator;

import java.util.List;

import br.edu.ifba.inf011.model.PlaylistItem;

public class RepeatAllIterator implements PlaylistIterator {

	private List<PlaylistItem> items;
	private Integer index;

	public RepeatAllIterator(List<PlaylistItem> items) {
		this.items = items;
		this.reset();
	}

	@Override
	public boolean temProximo() {
		return true;
	}

	@Override
	public PlaylistItem proximo() {
		if (index >= items.size()) {
			this.reset();
		}
		return items.get(index++);
	}

	public void reset() {
		this.index = 0;
	}
}
