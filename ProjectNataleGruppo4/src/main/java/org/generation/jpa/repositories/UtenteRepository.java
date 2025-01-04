package org.generation.jpa.repositories;

import java.util.List;

import org.generation.jpa.entities.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<UtenteEntity, Long>{
	
	List<UtenteEntity> findAll();
	
	UtenteEntity findByEmail(String email);
	
	UtenteEntity findById(long id);

}
