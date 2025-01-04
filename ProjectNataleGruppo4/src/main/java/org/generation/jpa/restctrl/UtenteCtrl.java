package org.generation.jpa.restctrl;

import java.util.ArrayList;
import java.util.List;

import org.generation.jpa.entities.UtenteEntity;
import org.generation.jpa.entities.VeicoloEntity;
import org.generation.jpa.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/utente")
@CrossOrigin
public class UtenteCtrl {
	
	@Autowired
	UtenteService utenteService;
	
	@GetMapping("")
	public ResponseEntity<List<UtenteEntity>> getAll() {
		try {    
          List<UtenteEntity> utenti = utenteService.getAll();
          return ResponseEntity.ok(utenti);
		}
		catch (Exception e) {
          return ResponseEntity.internalServerError().body(new ArrayList<UtenteEntity>());
		}
	}
	
	
	@GetMapping("/{email}")
	public ResponseEntity<UtenteEntity> getByEmail(@PathVariable String email) {
//		return utenteService.getByEmail(email);
		try {
            UtenteEntity utente = utenteService.getByEmail(email);
            if(utente != null){
                return ResponseEntity.ok(utente); //200                
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UtenteEntity());
            }
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(new UtenteEntity());
        }
	}
	
	@GetMapping("/id:{id}")
	public ResponseEntity<UtenteEntity> getById(@PathVariable long id) {
		try {
            UtenteEntity utente = utenteService.getById(id);
            if(utente != null){
                return ResponseEntity.ok(utente); //200                
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UtenteEntity());
            }
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(new UtenteEntity());
        }
	}
	
}
