package br.edu.ifba.inf011.model;

import java.util.List;

public class RepeatAll implements PlaylistIterator{
    private Player player;
    private Integer index;

    public RepeatAll(Player player) {
        this.player = player;
        this.reset();
    }

    @Override
    public boolean temProximo() {
        return this.index < this.player.getItems().size();
    }

    @Override
    public String proximo() {
        if(!temProximo()) this.reset();
        return this.player.getItems().get(index++).execute();
    }

    public void reset() {
        this.index = 0;
    }
}
