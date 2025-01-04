package org.generation.jpa.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "prenotazione")
public class PrenotazioneEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(nullable = false)
	private boolean attiva;
	
	@ManyToOne
    @JoinColumn(name = "veicolo_id", nullable = false)
    @JsonIgnore
	private VeicoloEntity veicolo;
	
	@Column(nullable = true)
	private LocalDateTime dataInizio;

    @Column(nullable = true)
    private LocalDateTime dataFine;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    @JsonIgnore
    private UtenteEntity utente;
    
    
	public PrenotazioneEntity() {
	}

	public UtenteEntity getUtente() {
		return utente;
	}

	public void setUtente(UtenteEntity utente) {
		this.utente = utente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAttiva() {
		return attiva;
	}

	public void setAttiva(boolean attiva) {
		this.attiva = attiva;
	}

	public VeicoloEntity getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(VeicoloEntity veicolo) {
		this.veicolo = veicolo;
	}

	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDateTime getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}

	public long getVeicoloId() {
		return veicolo.getId();
	}
	
	@Override
	public String toString() {
		return "PrenotazioneEntity [id=" + id + ", attiva=" + attiva + ",\n veicolo=" + veicolo + ", dataInizio="
				+ dataInizio + ", dataFine=" + dataFine + ",\n utente=" + utente + "]";
	}
	

	
    
    
	
}
