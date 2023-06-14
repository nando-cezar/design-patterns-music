package br.edu.ifba.inf011.model;

import java.util.Random;

public class RandomMode implements PlaylistIterator{
    private Player player;
    private Integer index;

    public RandomMode(Player player) {
        this.player = player;
        this.reset();
    }

    @Override
    public boolean temProximo() {
        return this.index < getListItemsSize();
    }

    @Override
    public String proximo() {
        Random random = new Random();
        var valorRandomico = random.nextInt(this.getListItemsSize());
        if(temProximo()){
            this.index++;
            return this.player.getItems().get(valorRandomico).execute();
        }
        return "";
    }

    private int getListItemsSize() {
        return this.player.getItems().size();
    }

    public void reset() {
        this.index = 0;
    }
}
