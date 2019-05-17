package model;

public class Ficha {
	private long id;
	private String nomeficha;
	private String exercicio;
	private int series;
	private int peso;
	private int repeticoes;
	
	
	
	
	public Ficha( long id,String nomeficha, String exercicio, int series, int peso,
			int repeticoes) {
		super();
		this.id = id;
		this.nomeficha = nomeficha;
		this.exercicio = exercicio;
		this.series = series;
		this.peso = peso;
		this.repeticoes = repeticoes;
		
	}
	
	public Ficha(){}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeficha() {
		return nomeficha;
	}
	public void setNomeficha(String nomeficha) {
		this.nomeficha = nomeficha;
	}
	public String getExercicio() {
		return exercicio;
	}
	public void setExercicio(String exercicio) {
		this.exercicio = exercicio;
	}
	public int getSeries() {
		return series;
	}
	public void setSeries(int series) {
		this.series = series;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getRepeticoes() {
		return repeticoes;
	}
	public void setRepeticoes(int repeticoes) {
		this.repeticoes = repeticoes;
	}
	
		

}
