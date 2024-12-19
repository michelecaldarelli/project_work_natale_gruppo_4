package org.generation.jpa.repositories;

import java.util.List;

import org.generation.jpa.entities.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UtenteRepository extends JpaRepository<UtenteEntity, Long>{
	
	@Query("select u from UtenteEntity u")
	List<UtenteEntity> findAllPROVA();
	

}
