package org.generation.jpa.restctrl;

import java.util.List;

import org.generation.jpa.entities.UtenteEntity;
import org.generation.jpa.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/utente")
public class UtenteCtrl {
	
	@Autowired
	UtenteService utenteService;
	
	@GetMapping("")
	public List<UtenteEntity> getAll() {
		return utenteService.getAll();
	}
	
}
