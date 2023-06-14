package br.edu.ifba.inf011.model;

import java.util.List;

/* Component: Decorator pattern */
public interface Musica extends PlaylistItem{
	public void reset();
	public Boolean finish();
	public String play();
	public void setConteudo(List<String> conteudo);
}
