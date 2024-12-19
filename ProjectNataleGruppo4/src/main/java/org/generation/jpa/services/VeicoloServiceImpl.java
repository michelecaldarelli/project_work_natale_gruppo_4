package org.generation.jpa.services;

import org.generation.jpa.entities.VeicoloEntity;
import org.generation.jpa.repositories.VeicoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeicoloServiceImpl implements VeicoloService{

	@Autowired
	VeicoloRepository veicoloRepository;
	
	@Override
	public VeicoloEntity postVeicolo(VeicoloEntity veicolo) {
		
		veicoloRepository.save(veicolo);
		return veicolo;
	}
	
}
