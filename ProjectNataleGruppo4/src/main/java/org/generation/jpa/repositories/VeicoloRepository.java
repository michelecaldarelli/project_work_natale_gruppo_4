package org.generation.jpa.repositories;

import org.generation.jpa.entities.VeicoloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeicoloRepository extends JpaRepository<VeicoloEntity, Long> {
	
	VeicoloEntity postVeicolo(String categoria, String alimentazione, String indirizzo, boolean disp);
}
