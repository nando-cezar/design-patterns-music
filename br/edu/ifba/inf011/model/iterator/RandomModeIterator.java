package br.edu.ifba.inf011.model.iterator;

import java.util.List;
import java.util.Random;

import br.edu.ifba.inf011.model.Player;
import br.edu.ifba.inf011.model.Playlist;
import br.edu.ifba.inf011.model.PlaylistItem;

public class RandomModeIterator implements PlaylistIterator {

	private final Random random;
	private Player player;
	private Integer index;

	public RandomModeIterator(Player player) {
		this.player = player;
		this.random = new Random();
		this.reset();
	}

	@Override
	public boolean temProximo() {
		return true;
	}

	@Override
	public PlaylistItem proximo() {
		List<PlaylistItem> items = player.getItems();
		PlaylistItem playlistItem = items.get(nextRandom());
		if (playlistItem instanceof Playlist) {
			return ((Playlist) playlistItem).randomize();
		}
		return playlistItem;
	}

	private int getListItemsSize() {
		return this.player
				.getItems()
				.size();
	}

	public void reset() {
		this.index = 0;
	}

	private int nextRandom() {
		List<PlaylistItem> items = player.getItems();
		return random.nextInt(items.size());
	}
}
