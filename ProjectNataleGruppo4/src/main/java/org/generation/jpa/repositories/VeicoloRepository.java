package org.generation.jpa.repositories;

import org.generation.jpa.entities.VeicoloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface VeicoloRepository extends JpaRepository<VeicoloEntity, Long> {
	
	VeicoloEntity findVeicoloById(long id);
	

	
	
}
