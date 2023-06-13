package br.edu.ifba.inf011.model;

import java.util.List;

/* Component: Decorator pattern */
public interface Musica{

	public String getNome();
	public String execute();
	public void reset();
	public Boolean finish();
	public String play();
}
