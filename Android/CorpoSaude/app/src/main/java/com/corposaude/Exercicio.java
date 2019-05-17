package com.corposaude;

public class Exercicio implements java.io.Serializable{
	private String nome;
	private String series;
	private String repeticoes;
	private String peso;
	
	public Exercicio()
	{
		super();
		this.nome = "";
		this.series = "";
		this.repeticoes = "";
		this.peso = "";
	}
	
	public Exercicio(String nome, String series, String repeticoes, String peso) {
		super();
		this.nome = nome;
		this.series = series;
		this.repeticoes = repeticoes;
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(String repeticoes) {
		this.repeticoes = repeticoes;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}
}
