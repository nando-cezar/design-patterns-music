package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.resources.ResourceLoader;

import java.io.IOException;
import java.util.List;

public class MusicaLetraTraduzida extends MusicaBase {

	private List<String> letras;
	private String nome;
	private Integer linha;

	public MusicaLetraTraduzida(Musica componente, String nome, String extensao) throws IOException {
		super(componente);
		super.setListaComponentes(this);
		this.nome = nome;
		this.letras = ResourceLoader.instance().loadTraducao(nome, extensao);
		this.reset();
	}

	public String getNome() {
		return this.nome;
	}
	
	public void reset() {
		this.linha = 0;
	}
	
	public Boolean finish() {
		return this.linha >= this.letras.size();
	}
	
	public String play() {
		return this.letras.get(this.linha++);
	}

	public void setLetras(List<String> letras) {
		this.letras = letras;
	}

}
