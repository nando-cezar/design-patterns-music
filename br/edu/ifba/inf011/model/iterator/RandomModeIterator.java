package br.edu.ifba.inf011.model.iterator;

import java.util.List;
import java.util.Random;

import br.edu.ifba.inf011.model.Player;
import br.edu.ifba.inf011.model.Playlist;
import br.edu.ifba.inf011.model.PlaylistItem;

public class RandomModeIterator implements PlaylistIterator {

	private final Random random;
	private List<PlaylistItem> items;

	public RandomModeIterator(List<PlaylistItem> items) {
		this.items = items;
		this.random = new Random();
	}

	@Override
	public boolean temProximo() {
		return true;
	}

	@Override
	public PlaylistItem proximo() {
		PlaylistItem playlistItem = items.get(nextRandom());
		if (playlistItem instanceof Playlist) {
			return ((Playlist) playlistItem).randomize();
		}
		return playlistItem;
	}
	private int nextRandom() {
		return random.nextInt(this.items.size());
	}
}
