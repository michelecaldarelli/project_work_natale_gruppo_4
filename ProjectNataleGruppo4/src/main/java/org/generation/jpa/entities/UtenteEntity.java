package org.generation.jpa.entities;

import java.util.Date;

import org.generation.jpa.dtos.Ruolo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "utente")
public class UtenteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long utente_id;
	
	@Column(length = 75, nullable = false)
	private String nome;
	@Column(length = 75, nullable = false)
	private String cognome;
	@Column(nullable = false)
	private Date dataNascita;
	@Column(length = 50, nullable = false)
	private String email;
	@Column(length = 20, nullable = false)
	private String password;
	@Column(length = 30, nullable = false)
	private String ruolo;
	
	public UtenteEntity() {
	}
	
	public long getUtente_id() {
		return utente_id;
	}
	public void setUtente_id(long utente_id) {
		this.utente_id = utente_id;
	}
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
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	
	
	
		
	
}
