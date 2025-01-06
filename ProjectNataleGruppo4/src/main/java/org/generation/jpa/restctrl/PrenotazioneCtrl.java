package org.generation.jpa.restctrl;

import org.generation.jpa.entities.PrenotazioneEntity;
import org.generation.jpa.entities.VeicoloEntity;
import org.generation.jpa.repositories.PrenotazioneRepository;
import org.generation.jpa.repositories.VeicoloRepository;
import org.generation.jpa.services.PrenotazioneService;
import org.generation.jpa.services.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prenotazione")
@CrossOrigin
public class PrenotazioneCtrl {
	
	@Autowired
	PrenotazioneService prenotazioneService;
	
	@Autowired
	VeicoloService veicoloService;
	
	@Autowired
	VeicoloRepository veicoloRepository;
	@Autowired
	PrenotazioneRepository prenotazioneRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<PrenotazioneEntity> getById(@PathVariable long id){
		try {
            PrenotazioneEntity prenotazione = prenotazioneService.getById(id);
            if(prenotazione != null){
                return ResponseEntity.ok(prenotazione); //200                
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PrenotazioneEntity());
            }
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(new PrenotazioneEntity());
        }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> cancellaPrenotazione(@PathVariable long id) {
		try {
			PrenotazioneEntity prenotazione = prenotazioneService.getById(id);
			if(prenotazione != null){
				
				if(prenotazione.isAttiva()) {
					VeicoloEntity v = veicoloService.getVeicoloById(prenotazione.getVeicoloId());
					v.setDisponibilita(true);
					veicoloRepository.save(v);
					
					prenotazione.setAttiva(false);
					prenotazioneRepository.save(prenotazione);
					return ResponseEntity.ok(prenotazione); //200                					
				}
				else {
					return ResponseEntity.badRequest().body("Errore: la prenotazione non è attiva");
				}
				
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PrenotazioneEntity());
            }
		}
		catch (Exception e) {
            return ResponseEntity.internalServerError().body(new PrenotazioneEntity());
        }
	}
	
}
