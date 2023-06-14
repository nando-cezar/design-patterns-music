package br.edu.ifba.inf011.model;

import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.model.resources.ResourceLoader;

/* Concrete Decorator: Decorator pattern */
/* Leaf: Composite pattern */
public class MusicaNotas extends MusicaBase {

	private List<String> conteudo;
	private Integer linha;

	public MusicaNotas(Musica componente) {
		super(componente);
		this.reset();
	}

	public void reset() {
		 this.linha = 0;
	}

	public Boolean finish() {
		return this.linha >= this.conteudo.size();
	}

	public String play() {
		return super.play() + "\n" + this.conteudo.get(this.linha++);
	}

	public void setConteudo(List<String> notas) {
		this.conteudo = notas;
	}

}
