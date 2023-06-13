package br.edu.ifba.inf011.model;

import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.model.resources.ResourceLoader;

/* Concrete Decorator: Decorator pattern */
/* Leaf: Composite pattern */
public class MusicaNotas extends MusicaBase {

	private List<String> notas;
	private Integer linha;

	public MusicaNotas(Musica componente) {
		super(componente);
		this.reset();
	}

	public void reset() {
		 this.linha = 0;
	}

	public Boolean finish() {
		return this.linha >= this.notas.size();
	}

	public String play() {
		return this.notas.get(this.linha++) + "\n" + super.play();
	}

	public void setAcordes(List<String> notas) {
		this.notas = notas;
	}

}
