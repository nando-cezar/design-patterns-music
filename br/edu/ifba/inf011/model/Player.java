package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.ifba.inf011.model.iterator.PlayerMode;

public class Player implements Iterable<PlaylistItem> {

	private List<PlayerListener> listeners;

	@FunctionalInterface
	public interface PlayerListener {

		void onChangeMode(PlayerMode mode);
	}

	private final List<PlaylistItem> items;
	private PlayerMode mode;
	private Integer index;
	
	public Player() {
		this.items = new ArrayList<>();
		this.listeners = new ArrayList<>();
		this.setMode(PlayerMode.PlayerAll);
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

	public List<PlaylistItem> getItems(){
		return this.items;
	}
	
	public void setMode(PlayerMode mode) {
		notificar();
		this.mode = mode;
	}
	public PlaylistIterator createIterator(){
		return this.mode.create(this);
	}

}
