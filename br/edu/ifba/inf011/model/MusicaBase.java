package br.edu.ifba.inf011.model;

import java.util.List;

/* Base Decorator: Decorator pattern */
public abstract class MusicaBase implements Musica {

    private Musica componente;

    public MusicaBase(Musica componente) {
        this.componente = componente;
    }

    @Override
    public String getNome() {
        return componente.getNome();
    }

    @Override
    public String execute() {
        System.out.println("\tExecutando MUSICA");
        StringBuffer str = new StringBuffer();
        while(!this.finish()){
            str.append(this.play() + "\n");
        }
        this.reset();
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

    @Override
    public void setConteudo(List<String> conteudo) {
        componente.setConteudo(conteudo);
    }

}
