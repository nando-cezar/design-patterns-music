package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.Player;

public enum PlayerMode {
	
	PlayerAll {
		@Override
		public PlaylistIterator createIterator(Player player) {
			return new PlayerAllIterator(player);
		}
	}, RepeatAll {
		@Override
		public PlaylistIterator createIterator(Player player) {
			return new RepeatAllIterator(player);
		}
	}, RandomMode {
		@Override
		public PlaylistIterator createIterator(Player player) {
			return new RandomModeIterator(player);
		}
	};

	public abstract PlaylistIterator createIterator(Player player);
}
