package br.edu.ifba.inf011.model;

import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class MusicaNotas extends MusicaBase {

	private List<String> notas;
	private String nome;
	private Integer linha;

	public MusicaNotas(Musica componente, String nome) throws IOException {
		super(componente);
		super.setListaComponentes(this);
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
		return this.notas.get(this.linha++);
	}

	public void setAcordes(List<String> notas) {
		this.notas = notas;
	}

}
