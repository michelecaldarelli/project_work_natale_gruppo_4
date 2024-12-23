package org.generation.jpa.restctrl;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.generation.jpa.entities.Categoria;
import org.generation.jpa.entities.UtenteEntity;
import org.generation.jpa.entities.VeicoloEntity;
import org.generation.jpa.repositories.VeicoloRepository;
import org.generation.jpa.services.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.criteria.Path;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/veicolo")
@CrossOrigin
public class VeicoloCtrl {
	
	@Autowired
	VeicoloService veicoloService;
	
	@Autowired
	VeicoloRepository veicoloRepository;
	
	@Autowired
	ServletContext servletContext;
	
	@PostMapping
	public ResponseEntity<?> addVeicolo(@RequestBody VeicoloEntity veicolo){
	     try {
	    	 veicoloService.postVeicolo(veicolo);
	         return ResponseEntity.ok(veicolo);
	     }
	     catch (DataIntegrityViolationException e) {
	         return ResponseEntity.badRequest().body("Errore inserimento dati, controllare le proprietà dell'oggetto");
	     }
	     catch (Exception e) {
	         return ResponseEntity.internalServerError().body(new VeicoloEntity());
	     }
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<VeicoloEntity> getVeicoloById(@PathVariable long id){
        try {
            VeicoloEntity v = veicoloService.getVeicoloById(id);
            if(v != null){
                return ResponseEntity.ok(v); //200                
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new VeicoloEntity());
            }
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(new VeicoloEntity());
        }
    }
	
	
	@PutMapping("/prenota:{id}")
	public ResponseEntity<?> prenotaVeicolo(@PathVariable long id){
		try {
			VeicoloEntity trovato = veicoloService.getVeicoloById(id);
			
			if(trovato != null && trovato.isDisponibilita())
			{
				VeicoloEntity v = veicoloService.prenotaVeicolo(trovato);
				
				return ResponseEntity.ok(v); 
				
			}else if(!trovato.isDisponibilita()) {
				
				return ResponseEntity.badRequest().body("Il veicolo non è disponibile.");
			}
			else {
				return  ResponseEntity.badRequest().body("Veicolo non trovato");				
			}
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new VeicoloEntity());
		}
		
	}
	
	@PutMapping("/lascia:{id}")
	public ResponseEntity<?> lasciaVeicolo(@PathVariable long id){
		try {
			VeicoloEntity trovato = veicoloService.getVeicoloById(id);
			
			if(trovato != null && !trovato.isDisponibilita())
			{
				VeicoloEntity v = veicoloService.lasciaVeicolo(trovato);
				
				return ResponseEntity.ok(v); 
				
			}else if(trovato.isDisponibilita()) {
				
				return ResponseEntity.badRequest().body("Il veicolo è già disponibile.");
			}
			else {
				return  ResponseEntity.badRequest().body("Veicolo non trovato");				
			}
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new VeicoloEntity());
		}
	}
	
	@GetMapping("")
	public ResponseEntity<List<VeicoloEntity>> getAll() {
		try {    
          List<VeicoloEntity> veicoli = veicoloService.getAll();
          return ResponseEntity.ok(veicoli);
		}
		catch (Exception e) {
          return ResponseEntity.internalServerError().body(new ArrayList<VeicoloEntity>());
		}
	}
	
	
	
	 

}
