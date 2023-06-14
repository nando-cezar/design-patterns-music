package br.edu.ifba.inf011.model.iterator;

import java.util.Iterator;
import java.util.List;

import br.edu.ifba.inf011.model.PlaylistItem;

public enum PlayerMode {

	PlayerAll {
		@Override
		public Iterator<PlaylistItem> getIterator(List<PlaylistItem> items) {
			return new PlayAllIterator(items);
		}
	}, RepeatAll {
		@Override
		public Iterator<PlaylistItem> getIterator(List<PlaylistItem> items) {
			return new RepeatAllIterator(items);
		}
	}, RandomMode {
		@Override
		public Iterator<PlaylistItem> getIterator(List<PlaylistItem> items) {
			return new RandomModeIterator(items);
		}
	};

	public abstract Iterator<PlaylistItem> getIterator(List<PlaylistItem> items);
}
