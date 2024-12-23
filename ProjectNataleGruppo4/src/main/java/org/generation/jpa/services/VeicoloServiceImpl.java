package org.generation.jpa.services;

import java.util.List;

import org.generation.jpa.entities.UtenteEntity;
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

	@Override
	public VeicoloEntity getVeicoloById(long id) {
		return veicoloRepository.findVeicoloById(id);
	}

	@Override
	public VeicoloEntity prenotaVeicolo(VeicoloEntity v) {

		v.setDisponibilita(false);
		veicoloRepository.save(v);
		
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
