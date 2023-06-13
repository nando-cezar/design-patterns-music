package br.edu.ifba.inf011.model;

import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.model.resources.ResourceLoader;

/* Concrete Decorator: Decorator pattern */
public class MusicaNotas extends MusicaBase implements PlaylistItem {

	private List<String> notas;
	private String nome;
	private Integer linha;

	public MusicaNotas(Musica componente, String nome) throws IOException {
		super(componente);
		this.nome = nome;
		this.notas = ResourceLoader.instance().loadNotas(nome);
		this.reset();
	}

	public String getNome() {
		return this.nome;
	}

	public void reset() {
		 this.linha = 0;
	}

	public Boolean finish() {
		return this.linha >= this.notas.size();
	}

	public String play() {
		return this.notas.get(this.linha++) + "\n" + this.componente.play();
	}

	public void setAcordes(List<String> notas) {
		this.notas = notas;
	}

}
