package br.edu.ifba.inf011.model;

import java.util.List;

/* COMPONENTE */
public interface Musica{

	public String getNome();
	public String execute();
	public void reset();
	public Boolean finish();
	public String play();
	public List<Musica> getListaComponentes();
	public void setListaComponentes(Musica musica);
}
