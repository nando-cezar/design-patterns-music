package br.edu.ifba.inf011.model;


import java.util.List;

/* Concrete Component: Decorator pattern */
/* Leaf: Composite pattern */
public class MusicaTemplate implements Musica {

    private String nome;
    private Integer linha;

    public MusicaTemplate(String nome) {
        this.nome = nome;
        this.reset();
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void reset() {
        this.linha = 0;
    }

    @Override
    public Boolean finish() {
        return this.linha > 0;
    }

    @Override
    public String play() {
        if(!this.finish()) {
            this.linha++;
            return "\n---------: \t\t" + this.getNome() + "\n";
        }
        return this.execute();
    }

    @Override
    public void setConteudo(List<String> conteudo) {}

    @Override
    public String execute() {return "";}

}
