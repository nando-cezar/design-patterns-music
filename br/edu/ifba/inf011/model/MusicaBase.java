package br.edu.ifba.inf011.model;

/* Base Decorator: Decorator pattern */
public class MusicaBase implements Musica {

    protected Musica componente;

    public MusicaBase(Musica componente) {
        this.componente = componente;
    }

    @Override
    public String nome() {
        return componente.nome();
    }

    @Override
    public String execute() {
        StringBuffer str = new StringBuffer();
        while(!this.finish()){
            str.append(this.play() + "\n");
        }
        return str.toString();
    }

    @Override
    public void reset() {
        componente.reset();
    }

    @Override
    public Boolean finish() {
        return componente.finish();
    }

    @Override
    public String play() {
        return componente.play();
    }

}
