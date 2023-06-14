package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.iterator.PlayerIterable;
import br.edu.ifba.inf011.model.iterator.PlayerMode;
import br.edu.ifba.inf011.model.iterator.PlaylistIterator;


public class Player implements PlayerIterable {

	private List<PlayerListener> listeners;

	public List<PlaylistItem> getItems() {
		return this.items;
	}

	@FunctionalInterface
	public interface PlayerListener {

		void onChangeMode(PlayerMode mode);
	}

	private List<PlaylistItem> items;
	private PlayerMode mode;
	private Integer index;

	public Player() {
		this.items = new ArrayList<>();
		this.listeners = new ArrayList<>();
		this.mode = PlayerMode.PlayerAll;
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

	public void addListeners(PlayerListener listener) {
		this.listeners.add(listener);
	}

	public void removeListener(PlayerListener listener) {
		this.listeners.remove(listener);
	}

	public void notificar() {
		for (PlayerListener listener : listeners) {
			listener.onChangeMode(mode);
		}
	}


	public void setMode(PlayerMode mode) {
		notificar();
		this.mode = mode;
	}

	@Override
	public PlaylistIterator createIterator() {
		return this.mode.createIterator(this);
	}

}
