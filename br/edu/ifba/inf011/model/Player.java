package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.ifba.inf011.model.iterator.PlayerMode;

public class Player implements Iterable<PlaylistItem> {

	private final List<PlaylistItem> items;
	private PlayerMode mode;

	public Player() {
		this.setMode(PlayerMode.PlayerAll);
		this.items = new ArrayList<>();
	}

	public void insert(PlaylistItem item) {
		this.items.add(item);
	}

	public boolean temProximo() {
		return false;
	}

	public String proximo() {
		return null;
	}

	public void setMode(PlayerMode mode) {
		this.mode = mode;
	}


	@Override
	public Iterator<PlaylistItem> iterator() {
		return mode.getIterator(items);
	}
}
