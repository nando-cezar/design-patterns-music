package br.edu.ifba.inf011.model.iterator;

import java.util.List;

import br.edu.ifba.inf011.model.composite.PlaylistItem;

public enum PlayerMode {
	
	PlayerAll {
		@Override
		public PlaylistIterator createIterator(List<PlaylistItem> items) {
			return new PlayerAllIterator(items);
		}
	}, RepeatAll {
		@Override
		public PlaylistIterator createIterator(List<PlaylistItem> items) {
			return new RepeatAllIterator(items);
		}
	}, RandomMode {
		@Override
		public PlaylistIterator createIterator(List<PlaylistItem> items) {
			return new RandomModeIterator(items);
		}
	};

	public abstract PlaylistIterator createIterator(List<PlaylistItem> items);
}
