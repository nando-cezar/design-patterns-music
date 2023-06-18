package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.PlaylistItem;

/* Iterator: Iterator pattern */
public interface PlaylistIterator {
    boolean temProximo();
    PlaylistItem proximo();
}
