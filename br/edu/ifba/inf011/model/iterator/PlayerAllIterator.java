package br.edu.ifba.inf011.model.iterator;

import java.util.List;

import br.edu.ifba.inf011.model.composite.PlaylistItem;
import br.edu.ifba.inf011.model.iterator.PlaylistIterator;

/* Concrete Iterator: Iterator pattern */
public class PlayerAllIterator implements PlaylistIterator {
    private final List<PlaylistItem> items;
    private Integer index;

    public PlayerAllIterator(List<PlaylistItem> items) {
        this.items = items;
        this.reset();
    }

    @Override
    public boolean temProximo() {
        return this.index < this.items.size();
    }

    @Override
    public PlaylistItem proximo() {
        if(this.temProximo()) return items.get(index++);
        return null;
    }

    public void reset() {
        this.index = 0;
    }
}
