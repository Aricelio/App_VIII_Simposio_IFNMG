package br.edu.tads.DomainModel;

import java.util.Date;

public class Atividade {
	
	
	// Variaveis...............................
	private String nome;
	private Date data;
	private String local;
	
	// Getters ans Setters.....................
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	// toString.................................
	@Override
	public String toString() {
		return this.nome 
				+ "\nHorário: "
				+ "\nLocal: " + this.local;
	}
}
