package br.edu.ifba.inf011.model.decorator;

import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.model.Musica;

/* Concrete Decorator: Decorator pattern */
/* Leaf: Composite pattern */
public class MusicaLetraOriginal extends MusicaBase {

	private List<String> letraOriginal;

	public MusicaLetraOriginal(Musica componente) throws IOException {
		super(componente);
		this.reset();
		this.setLetraOriginal();
	}

	public void setLetraOriginal() throws IOException {
		this.letraOriginal = resourceLoader.loadLetra(getNome());
	}

	public Boolean finish() {
		return this.linha >= this.letraOriginal.size();
	}

	public String play() {
		return this.component.play() + "\n" + this.letraOriginal.get(this.linha++);
	}


}
