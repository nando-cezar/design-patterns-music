package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.resources.ResourceLoader;

import java.io.IOException;
import java.util.List;

/* Concrete Decorator: Decorator pattern */
/* Leaf: Composite pattern */
public class MusicaLetraTraduzida extends MusicaBase {

	private List<String> conteudo;
	private Integer linha;

	public MusicaLetraTraduzida(Musica componente) {
		super(componente);
		this.reset();
	}

	public void reset() {
		super.reset();
		this.linha = 0;
	}
	
	public Boolean finish() {
		return this.linha >= this.conteudo.size();
	}

	public String play() {
		return super.play() + "\n" + this.conteudo.get(this.linha++);
	}

	public void setConteudo(List<String> letras) {
		this.conteudo = letras;
	}

}
