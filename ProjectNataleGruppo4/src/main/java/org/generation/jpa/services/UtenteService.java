package org.generation.jpa.services;

import java.util.List;

import org.generation.jpa.entities.UtenteEntity;
import org.springframework.stereotype.Service;

@Service
public interface UtenteService {
	
	public List<UtenteEntity> getAll();
}
