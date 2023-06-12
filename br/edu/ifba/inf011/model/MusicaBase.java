package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

/* COMPOSITE */
public class MusicaBase implements Musica {

    private Musica componente;
    private static final List<Musica> listaComponentes = new ArrayList<Musica>();
    public MusicaBase(Musica componente) {
        this.componente = componente;
    }

    @Override
    public String getNome() {
        return componente.getNome();
    }

    @Override
    public String execute() {
        StringBuffer str = new StringBuffer();
        while(!this.finish()){
            for (Musica componente: this.getListaComponentes()) {
                str.append(componente.play() + "\n");
            }
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

    @Override
    public List<Musica> getListaComponentes() {
        return listaComponentes;
    }

    @Override
    public void setListaComponentes(Musica musica) {
        listaComponentes.add(musica);
    }
}
