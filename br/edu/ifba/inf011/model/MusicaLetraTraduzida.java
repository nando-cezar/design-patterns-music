package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.resources.ResourceLoader;

import java.io.IOException;
import java.util.List;

/* Concrete Decorator: Decorator pattern */
/* Leaf: Composite pattern */
public class MusicaLetraTraduzida extends MusicaBase {

	private List<String> letras;
	private Integer linha;

	public MusicaLetraTraduzida(Musica componente) {
		super(componente);
		this.reset();
	}

	public void reset() {
		this.linha = 0;
	}
	
	public Boolean finish() {
		return this.linha >= this.letras.size();
	}

	public String play() {
		return this.letras.get(this.linha++) + "\n" + super.play();
	}

	public void setLetras(List<String> letras) {
		this.letras = letras;
	}

}
