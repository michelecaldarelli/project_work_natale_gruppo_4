package org.generation.jpa.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PrenotazioneEntity> prenotazioni = new ArrayList<>();

	
	public List<PrenotazioneEntity> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<PrenotazioneEntity> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

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

	@Override
	public String toString() {
		return "UtenteEntity [utente_id=" + utente_id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita="
				+ dataNascita + ", email=" + email + ", password=" + password + ", ruolo=" + ruolo + "]";
	}
	
	
	// Metodo per aggiungere una prenotazione
	public void addPrenotazione(PrenotazioneEntity prenotazione) {
	    prenotazioni.add(prenotazione);
	    prenotazione.setUtente(this);
	}

	// Metodo per rimuovere una prenotazione
	public void removePrenotazione(PrenotazioneEntity prenotazione) {
	    prenotazioni.remove(prenotazione);
	    prenotazione.setUtente(null);
	}
	
	
	
	
		
	
}
