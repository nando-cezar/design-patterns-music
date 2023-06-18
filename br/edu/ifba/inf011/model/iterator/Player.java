package br.edu.ifba.inf011.model.iterator;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.composite.PlaylistItem;
import br.edu.ifba.inf011.model.observer.PlayerListener;


/* Concrete Aggregate: Iterator pattern */
/* Subject: Observer pattern */
public class Player implements PlayerIterable {

	private final List<PlaylistItem> items;
	private final List<PlayerListener> listeners;
	private PlayerMode mode;

	public Player() {
		this.items = new ArrayList<>();
		this.listeners = new ArrayList<>();
		this.mode = PlayerMode.PlayerAll;
	}

	@Override
	public void addItem(PlaylistItem item) {
		this.items.add(item);
	}

	@Override
	public void removeItem(PlaylistItem item) {
		this.items.remove(item);
	}

	@Override
	public PlaylistIterator createIterator() {
		return this.mode.createIterator(items);
	}

	public void setMode(PlayerMode mode) {
		this.mode = mode;
		notificar();
	}

	public PlayerMode getMode(){
		return this.mode;
	}

	public void addListeners(PlayerListener listener) {
		this.listeners.add(listener);
	}

	public void removeListener(PlayerListener listener) {
		this.listeners.remove(listener);
	}

	public void notificar() {
		for (PlayerListener listener : listeners) {
			listener.onChangeMode();
		}
	}

}
