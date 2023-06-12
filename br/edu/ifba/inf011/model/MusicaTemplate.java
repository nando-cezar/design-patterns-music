package br.edu.ifba.inf011.model;

public class MusicaTemplate implements Musica {

    private String nome;

    public MusicaTemplate(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }

    public void reset() {}

    public Boolean finish() {return true;}

    public String play() {return "";}

    public String execute() {
        return "";
    }
}
