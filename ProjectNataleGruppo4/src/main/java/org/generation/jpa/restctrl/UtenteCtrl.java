package org.generation.jpa.restctrl;

import java.util.List;

import org.generation.jpa.entities.UtenteEntity;
import org.generation.jpa.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<UtenteEntity> getAll() {
		return utenteService.getAll();
	}
	
	@GetMapping("/{email}")
	public UtenteEntity getByEmail(@PathVariable String email) {
		return utenteService.getByEmail(email);
	}
	
}
