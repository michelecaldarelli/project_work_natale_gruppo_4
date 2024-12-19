package org.generation.jpa.services;

import java.util.List;

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
		List<UtenteEntity> utenti = utenteRepository.findAllPROVA();
		return utenti;
	}

}
