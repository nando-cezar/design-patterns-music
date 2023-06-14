package br.edu.ifba.inf011.model;

public class PlayerAll implements PlaylistIterator{
    private Player player;
    private Integer index;

    public PlayerAll(Player player) {
        this.player = player;
        this.reset();
    }

    @Override
    public boolean temProximo() {
        return this.index < this.player.getItems().size();
    }

    @Override
    public String proximo() {
        if(this.temProximo())
            return this.player.getItems().get(index++).execute();
        return "";
    }

    public void reset() {
        this.index = 0;
    }
}
