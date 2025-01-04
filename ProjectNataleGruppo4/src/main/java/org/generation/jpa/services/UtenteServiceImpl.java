package org.generation.jpa.services;

import java.util.List;

import org.generation.jpa.entities.PrenotazioneEntity;
import org.generation.jpa.entities.UtenteEntity;
import org.generation.jpa.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService{

	@Autowired
	UtenteRepository utenteRepository;
	
	@Override
	public List<UtenteEntity> getAll() {
		List<UtenteEntity> utenti = utenteRepository.findAll();
		return utenti;
	}

	@Override
	public UtenteEntity getByEmail(String email) {
		return utenteRepository.findByEmail(email);
	}

	@Override
	public UtenteEntity getById(long id) {
		return utenteRepository.findById(id);
	}

}
