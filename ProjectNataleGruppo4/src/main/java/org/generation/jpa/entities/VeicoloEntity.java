package org.generation.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "veicolo")
public class VeicoloEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 75, nullable = false)
	private String categoria;
	
	@Column(length = 150)
	private String descrizione;
	
	@Column(length = 50, nullable = false)
	private String alimentazione;
	
	@Column(length = 50, nullable = false)
	private String indirizzo;
	
	@Column(nullable = false)
	private boolean disponibilita;
	
	@Column(length = 50)
	private String immagineVeicolo;
	
	

	public VeicoloEntity(String categoria, String alimentazione, String indirizzo, boolean disponibilita) {
		this.categoria = categoria;
		this.alimentazione = alimentazione;
		this.indirizzo = indirizzo;
		this.disponibilita = disponibilita;
	}
	// Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getAlimentazione() {
		return alimentazione;
	}
	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public boolean isDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(boolean disponibilita) {
		this.disponibilita = disponibilita;
	}
	public String getImmagineVeicolo() {
		return immagineVeicolo;
	}
	public void setImmagineVeicolo(String immagineVeicolo) {
		this.immagineVeicolo = immagineVeicolo;
	}
	
	

}
