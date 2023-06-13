package br.edu.ifba.inf011.model;

import java.util.List;

/* LEAF */
public class MusicaTemplate implements Musica, PlaylistItem {

    private String nome;

    public MusicaTemplate(String nome) {
        this.nome = nome;
    }
    @Override
    public String getNome() {
        return this.nome;
    }
    @Override
    public void reset() {}
    @Override
    public Boolean finish() {return true;}
    @Override
    public String play() {return "";}
    public String execute() {
        return "";
    }


}
