package br.edu.ifba.inf011.model.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import br.edu.ifba.inf011.model.Playlist;
import br.edu.ifba.inf011.model.PlaylistItem;

public class RandomModeIterator implements Iterator<PlaylistItem> {

	private final Random random;
	int index;
	List<PlaylistItem> items;

	public RandomModeIterator(List<PlaylistItem> items) {
		this.items = items;
		random = new Random();
		index = nextRandom();
	}

	private int nextRandom() {
		return random.nextInt(this.items.size());
	}

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public PlaylistItem next() {
		PlaylistItem playlistItem = items.get(nextRandom());
		if (playlistItem instanceof Playlist) {
			return ((Playlist) playlistItem).randomize();
		}
		return playlistItem;
	}
}
