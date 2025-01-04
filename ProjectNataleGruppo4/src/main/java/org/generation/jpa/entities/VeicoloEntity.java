package org.generation.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "veicolo")
public class VeicoloEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 150, nullable = false)
	private String marca;
	
	@Column(length = 150, nullable = false)
	private String modello;
	
	@Column(columnDefinition = "ENUM('BICICLETTA', 'MACCHINA', 'MOTO')", nullable = true)
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
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
	
	@OneToMany(mappedBy = "veicolo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PrenotazioneEntity> prenotazioni = new ArrayList<>();

	public VeicoloEntity() {
	}
	
	
	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModello() {
		return modello;
	}


	public void setModello(String modello) {
		this.modello = modello;
	}


	// Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	


	public List<PrenotazioneEntity> getPrenotazioni() {
		return prenotazioni;
	}


	public void setPrenotazioni(List<PrenotazioneEntity> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}


	public VeicoloEntity(long id, String marca, String modello, Categoria categoria, String descrizione,
			String alimentazione, String indirizzo, boolean disponibilita, String immagineVeicolo) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.categoria = categoria;
		this.descrizione = descrizione;
		this.alimentazione = alimentazione;
		this.indirizzo = indirizzo;
		this.disponibilita = disponibilita;
		this.immagineVeicolo = immagineVeicolo;
	}


	@Override
	public String toString() {
		return "VeicoloEntity [id=" + id + ", marca=" + marca + ", modello=" + modello + ", categoria=" + categoria
				+ ", descrizione=" + descrizione + ", alimentazione=" + alimentazione + ", indirizzo=" + indirizzo
				+ ", disponibilita=" + disponibilita + ", immagineVeicolo=" + immagineVeicolo + "]";
	}
	
	
	// Metodo per aggiungere una prenotazione
	public void addPrenotazione(PrenotazioneEntity prenotazione) {
	    prenotazioni.add(prenotazione);
	    prenotazione.setVeicolo(this);
	}

	// Metodo per rimuovere una prenotazione
	public void removePrenotazione(PrenotazioneEntity prenotazione) {
	    prenotazioni.remove(prenotazione);
	    prenotazione.setVeicolo(null);
	}
	

}
