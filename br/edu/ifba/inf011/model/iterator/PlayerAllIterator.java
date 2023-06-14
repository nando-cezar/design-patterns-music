package br.edu.ifba.inf011.model.iterator;

import java.util.List;

import br.edu.ifba.inf011.model.Player;
import br.edu.ifba.inf011.model.PlaylistItem;

public class PlayerAllIterator implements PlaylistIterator {
    private Player player;
    private Integer index;

    public PlayerAllIterator(Player player) {
        this.player = player;
        this.reset();
    }

    @Override
    public boolean temProximo() {
        return this.index < this.player.getItems().size();
    }

    @Override
    public PlaylistItem proximo() {
        if(this.temProximo()) {
            List<PlaylistItem> items = this.player.getItems();
            return items.get(index++);
        }
        return null;
    }

    public void reset() {
        this.index = 0;
    }
}
