package br.edu.ifba.inf011.model.decorator;

import br.edu.ifba.inf011.model.resources.ResourceLoader;

/* Decorator: Decorator pattern */
public abstract class MusicaBase implements Musica {

	protected Musica component;
	protected ResourceLoader resourceLoader;
	protected int linha;

	public MusicaBase(Musica component) {
		this.component = component;
		this.resourceLoader = ResourceLoader.instance();
	}

	@Override
	public String getNome() {
		return component.getNome();
	}

	@Override
	public String execute() {
		reset();
		StringBuilder builder = new StringBuilder();
		while (!finish()) {
			builder.append(play());
		}
		return builder.toString();
	}

	@Override
	public void reset() {
		this.linha = 0;
		component.reset();
	}
}
