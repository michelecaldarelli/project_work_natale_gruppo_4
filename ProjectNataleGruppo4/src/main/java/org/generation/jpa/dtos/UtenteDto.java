package org.generation.jpa.dtos;

import java.util.Date;

import org.generation.jpa.entities.Ruolo;

public class UtenteDto {
	private String nome;
	private String email;
	private Ruolo ruolo;
	
	
	
	public UtenteDto() {
	}

	public UtenteDto(String nome, String email, Ruolo ruolo) {
		this.nome = nome;
		this.email = email;
		this.ruolo = ruolo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
