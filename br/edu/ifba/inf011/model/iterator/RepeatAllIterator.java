package br.edu.ifba.inf011.model.iterator;

import java.util.List;

import br.edu.ifba.inf011.model.Player;
import br.edu.ifba.inf011.model.PlaylistItem;

public class RepeatAllIterator implements PlaylistIterator {

	private Player player;
	private Integer index;

	public RepeatAllIterator(Player player) {
		this.player = player;
		this.reset();
	}

	@Override
	public boolean temProximo() {
		return true;
	}

	@Override
	public PlaylistItem proximo() {
		List<PlaylistItem> items = this.player.getItems();
		if (index >= items.size()) {
			this.reset();
		}
		return items.get(index++);
	}

	public void reset() {
		this.index = 0;
	}
}
