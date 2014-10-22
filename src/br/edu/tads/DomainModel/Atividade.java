package br.edu.tads.DomainModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.net.ParseException;

public class Atividade {

	// Variaveis...............................
	private String nome;
	private Date data;
	private String local;

	
	// Construtor..............................
	public Atividade() {
		super();
		this.local = "";
	}

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
		try {
			String strdata = converteDateToString(this.data);
			if (this.local.equals("")) {
				return "\n" 
						+ this.nome 
						+ "\nHorário: " + strdata;
			} else {
				return "\n" 
						+ this.nome 
						+ "\nHorário: " + strdata 
						+ "\nLocal: " 	+ this.local;
			}
		} catch (java.text.ParseException e) {
			return null;
		}
	}

	// Método que converte uma Data em String....
	public String converteDateToString(Date data)
			throws java.text.ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String dateString = dateFormat.format(data);
		return dateString;
	}
}
