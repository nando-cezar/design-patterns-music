package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

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
        return componente.execute();
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

    public List<Musica> getListaComponentes() {
        return listaComponentes;
    }

    public static void setListaComponentes(Musica musica) {
        listaComponentes.add(musica);
    }
}
