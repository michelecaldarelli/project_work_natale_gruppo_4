package org.generation.jpa.entities;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	private LocalDate dataNascita;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@Column(length = 20, nullable = false)
	private String password;
	
	@Column(columnDefinition = "ENUM('ADMIN', 'UTENTE')", nullable = true)
	@Enumerated(EnumType.STRING)
	private Ruolo ruolo;
	
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
	
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	
	public void setDataNascita(LocalDate dataNascita) {
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
	
	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	
	
	
	
		
	
}
