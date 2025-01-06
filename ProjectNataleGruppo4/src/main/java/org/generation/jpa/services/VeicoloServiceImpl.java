package org.generation.jpa.services;

import java.util.List;

import org.generation.jpa.dtos.UtenteDto;
import org.generation.jpa.entities.PrenotazioneEntity;
import org.generation.jpa.entities.UtenteEntity;
import org.generation.jpa.entities.VeicoloEntity;
import org.generation.jpa.repositories.PrenotazioneRepository;
import org.generation.jpa.repositories.VeicoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class VeicoloServiceImpl implements VeicoloService{

	@Autowired
	VeicoloRepository veicoloRepository;
	@Autowired
	PrenotazioneRepository prenotazioneRepository;
	@Autowired
	private HttpSession session;
	@Autowired
	UtenteService utenteService;
	
	
	
	@Override
	public VeicoloEntity postVeicolo(VeicoloEntity veicolo) {
		veicoloRepository.save(veicolo);
		return veicolo;
	}

	@Override
	public VeicoloEntity getVeicoloById(long id) {
		return veicoloRepository.findVeicoloById(id);
	}

	@Override
	public VeicoloEntity prenotaVeicolo(VeicoloEntity v) {

		v.setDisponibilita(false);
		veicoloRepository.save(v);
		PrenotazioneEntity prenotazione = new PrenotazioneEntity();
		UtenteDto utente = (UtenteDto) session.getAttribute("user");
		prenotazione.setUtente(utenteService.getByEmail(utente.getEmail()));
		prenotazione.setAttiva(true);
		prenotazione.setVeicolo(v);
		System.out.println("\n\n\n\n\n\n");
		System.out.println(prenotazione);
		prenotazioneRepository.save(prenotazione);
		return v;
	}

	@Override
	public VeicoloEntity lasciaVeicolo(VeicoloEntity v) {
		
		v.setDisponibilita(true);
		veicoloRepository.save(v);
		
		return v;
	}

	@Override
	public List<VeicoloEntity> getAll() {
		List<VeicoloEntity> veicoli = veicoloRepository.findAll();
		return veicoli;
	}
	
}
