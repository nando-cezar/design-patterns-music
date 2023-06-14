package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.PlaylistItem;

public interface PlaylistIterator {
    public boolean temProximo();
    public PlaylistItem proximo();
}
