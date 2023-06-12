package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.resources.ResourceLoader;

import java.io.IOException;
import java.util.List;

public class MusicaLetraOriginal extends MusicaBase {

	private List<String> letras;
	private String nome;
	private Integer linha;

	public MusicaLetraOriginal(Musica componente, String nome) throws IOException {
		super(componente);
		MusicaBase.setListaComponentes(this);
		this.nome = nome;
		this.letras = ResourceLoader.instance().loadLetra(nome);
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

	public String execute() {
		StringBuffer str = new StringBuffer();
		//this.reset();
		while(!this.finish()){
			for (Musica componente: super.getListaComponentes()) {
				str.append(componente.play() + "\n");
			}
		}
		return str.toString();
	}
}
