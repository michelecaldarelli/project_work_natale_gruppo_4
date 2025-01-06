package org.generation.jpa.services;

import java.util.Optional;

import org.generation.jpa.entities.PrenotazioneEntity;
import org.generation.jpa.entities.VeicoloEntity;
import org.generation.jpa.repositories.PrenotazioneRepository;
import org.generation.jpa.repositories.VeicoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

	@Autowired
	VeicoloRepository veicoloRepository;
	@Autowired
	PrenotazioneRepository prenotazioneRepository;

	@Override
	public PrenotazioneEntity cancellaPrenotazione(PrenotazioneEntity p) {
		VeicoloEntity v = p.getVeicolo();
		v.setDisponibilita(true);
		veicoloRepository.save(v);
		
		p.setAttiva(false);
		prenotazioneRepository.save(p);
		
		return p;
	}

	@Override
	public PrenotazioneEntity getById(long id) {
		return prenotazioneRepository.findById(id);
	}
	
}
