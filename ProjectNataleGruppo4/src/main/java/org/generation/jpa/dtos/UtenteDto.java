package org.generation.jpa.dtos;

import java.util.Date;

import org.generation.jpa.entities.Ruolo;

public class UtenteDto {
	private long id;
	private String nome;
	private String email;
	private Ruolo ruolo;
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UtenteDto() {
	}
	
	public UtenteDto(long id, String nome, String email, Ruolo ruolo) {
		this.id = id;
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

	@Override
	public String toString() {
		return "UtenteDto [id=" + id + ", nome=" + nome + ", email=" + email + ", ruolo=" + ruolo + "]";
	}

	
	
	
	
	
}
