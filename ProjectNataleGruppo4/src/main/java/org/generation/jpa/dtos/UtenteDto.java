package org.generation.jpa.dtos;

import java.util.Date;

import org.generation.jpa.entities.Ruolo;

public class UtenteDto {
	private String nome;
	private String cognome;
	private String email;
	private Ruolo ruolo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	
	
	
}
