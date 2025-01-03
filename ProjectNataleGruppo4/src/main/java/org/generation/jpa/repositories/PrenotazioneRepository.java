package org.generation.jpa.repositories;

import org.generation.jpa.entities.PrenotazioneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<PrenotazioneEntity, Long>{

}
