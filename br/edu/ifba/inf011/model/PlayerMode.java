package br.edu.ifba.inf011.model;

import java.util.List;

public enum PlayerMode {
	
	PlayerAll {
		@Override
		public PlaylistIterator create(Player player) {
			return new PlayerAll(player);
		}
	}, RepeatAll {
		@Override
		public PlaylistIterator create(Player player) {
			return new RepeatAll(player);
		}
	}, RandomMode {
		@Override
		public PlaylistIterator create(Player player) {
			return new RandomMode(player);
		}
	};

	public abstract PlaylistIterator create(Player player);
}
