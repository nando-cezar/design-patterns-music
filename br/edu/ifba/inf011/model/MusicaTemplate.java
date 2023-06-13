package br.edu.ifba.inf011.model;


/* Concrete Component: Decorator pattern */
/* Leaf: Composite pattern */
public record MusicaTemplate(String nome) implements Musica {

    @Override
    public void reset() {}

    @Override
    public Boolean finish() {
        return true;
    }

    @Override
    public String play() {
        return "";
    }

    @Override
    public String execute() {
        return "";
    }

}
