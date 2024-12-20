package org.generation.jpa.services;

import java.util.List;

import org.generation.jpa.entities.VeicoloEntity;
import org.springframework.stereotype.Service;

@Service
public interface VeicoloService {

	VeicoloEntity postVeicolo(VeicoloEntity veicolo);
	
	VeicoloEntity getVeicoloById(long id);
	
	VeicoloEntity prenotaVeicolo(VeicoloEntity v);
	
	VeicoloEntity lasciaVeicolo(VeicoloEntity v);
	
	List<VeicoloEntity> getAll();
	
}
