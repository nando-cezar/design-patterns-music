package br.edu.ifba.inf011.model.decorator;

import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.model.Musica;

/* Concrete Decorator: Decorator pattern */
/* Leaf: Composite pattern */
public class MusicaLetraTraduzida extends MusicaBase {

	private List<String> traducao;

	private final String extensao;

	public MusicaLetraTraduzida(Musica componente, String extensao) throws IOException {
		super(componente);
		this.extensao = extensao;
		this.reset();
		this.setTraducao();
	}

	public void setTraducao() throws IOException {
		this.traducao = resourceLoader.loadTraducao(getNome(), extensao);
	}

	public Boolean finish() {
		return this.linha >= this.traducao.size();
	}

	public String play() {
		return this.component.play() + "\n" + this.traducao.get(this.linha++);
	}

}
