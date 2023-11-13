package aula;

import java.util.Date;

public class HistoricoPeso {

	private int id;
	private Date data;
	private double peso;
	
	

	public HistoricoPeso() {
		
	}

	public HistoricoPeso( Date data, double peso) {
		this.data = data;
		this.peso = peso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	
	
}
