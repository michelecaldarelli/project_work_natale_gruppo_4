package org.generation.jpa.services;

import org.generation.jpa.entities.PrenotazioneEntity;
import org.springframework.stereotype.Service;

@Service
public interface PrenotazioneService {
	
	PrenotazioneEntity cancellaPrenotazione(PrenotazioneEntity p);
	
	PrenotazioneEntity getById(long id);
}
