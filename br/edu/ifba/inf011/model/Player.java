package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player {

	private List<PlaylistItem> items;
	private PlayerMode mode;

	public Player() {
		this.setMode(PlayerMode.RandomMode);
		this.items = new ArrayList<PlaylistItem>();
	}

	public void insert(PlaylistItem item) {
		this.items.add(item);
	}

	public void remove(PlaylistItem item) {
		this.items.remove(item);
	}

	public List<PlaylistItem> getItems(){
		return this.items;
	}

	public void setMode(PlayerMode mode) {
		this.mode = mode;
	}
	public PlaylistIterator createIterator(){
		return this.mode.create(this);
	}

}
