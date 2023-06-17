package br.edu.ifba.inf011.model.iterator;

import java.util.List;

import br.edu.ifba.inf011.model.Player;
import br.edu.ifba.inf011.model.PlaylistItem;

public class PlayerAllIterator implements PlaylistIterator {
    private List<PlaylistItem> items;
    private Integer index;

    public PlayerAllIterator(List<PlaylistItem> items) {
        this.items = this.items;
        this.reset();
    }

    @Override
    public boolean temProximo() {
        return this.index < this.items.size();
    }

    @Override
    public PlaylistItem proximo() {
        if(this.temProximo()) {
            return items.get(index++);
        }
        return null;
    }

    public void reset() {
        this.index = 0;
    }
}
