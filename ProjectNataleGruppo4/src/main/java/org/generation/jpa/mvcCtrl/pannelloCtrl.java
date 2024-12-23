package org.generation.jpa.mvcCtrl;

import org.generation.jpa.entities.Categoria;
import org.generation.jpa.entities.VeicoloEntity;
import org.generation.jpa.repositories.VeicoloRepository;
import org.generation.jpa.services.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletContext;


@RestController
@RequestMapping("/pannello")
@CrossOrigin
public class pannelloCtrl {

	@Autowired
	VeicoloService veicoloService;
	
	@Autowired
	VeicoloRepository veicoloRepository;
	
	@Autowired
	ServletContext servletContext;
	
	
	
	@PostMapping("")
	public ResponseEntity<?> addVeicoloFromForm(
	        @RequestParam("categoria-veicolo") Categoria categoria,
	        @RequestParam("marca") String marca,
	        @RequestParam("modello") String modello,
	        @RequestParam("descrizione") String descrizione,
	        @RequestParam("alimentazione") String alimentazione,
	        @RequestParam("indirizzo") String indirizzo,
	        @RequestParam(value = "disponibilita", required = false) Boolean disponibilita) {

	  

	   
	    VeicoloEntity veicolo = new VeicoloEntity();
	    veicolo.setCategoria(categoria);
	    veicolo.setMarca(marca);
	    veicolo.setModello(modello);
	    veicolo.setDescrizione(descrizione);
	    veicolo.setAlimentazione(alimentazione);
	    veicolo.setIndirizzo(indirizzo);
	    veicolo.setDisponibilita(disponibilita != null && disponibilita);  

	    
	    try {
	        veicoloService.postVeicolo(veicolo);  
	        return ResponseEntity.ok(veicolo);  
	    } catch (DataIntegrityViolationException e) {
	        return ResponseEntity.badRequest().body("Errore nell'inserimento dei dati.");
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().body("Errore del server.");
	    }
	}

}
