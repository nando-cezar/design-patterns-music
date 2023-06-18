package br.edu.ifba.inf011.model.decorator;

import java.io.IOException;
import java.util.List;

/* Concrete Decorator: Decorator pattern */
/* Leaf: Composite pattern */
public class MusicaNotas extends MusicaBase {

	private List<String> notas;

	public MusicaNotas(Musica componente) throws IOException {
		super(componente);
		this.reset();
		this.setNotas();
	}

	public void setNotas() throws IOException {
		this.notas = resourceLoader.loadNotas(getNome());
	}

	public Boolean finish() {
		return this.linha >= this.notas.size();
	}

	public String play() {
		return component.play() + "\n" + this.notas.get(this.linha++);
	}

}
