package org.generation.jpa.mvcCtrl;

import org.generation.jpa.dtos.UtenteDto;
import org.generation.jpa.entities.UtenteEntity;
import org.generation.jpa.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;

//@RequestMapping("/formLoginBackend.html")
//@SessionAttributes("currentUser")
@Controller
public class loginCtrl {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	UtenteService utenteService;
	
	
	@GetMapping("/login")
	public String loginpage() {
		return "loginPage";
	}
	
	@PostMapping("/login")
	public ResponseEntity<UtenteEntity> login(UtenteEntity utente) {
		
		UtenteEntity utenteTrovato = utenteService.getByEmail(utente.getEmail());
		System.out.println(utenteTrovato.getEmail());
		return ResponseEntity.ok(utente);	
		
//		UtenteEntity utenteTrovato = utenteService.getByEmail(utente.getEmail());
//		if (utenteTrovato.getEmail() != null) {
//			if (utente.getPassword().equals(utenteTrovato.getPassword())) {
//				return ResponseEntity.ok("Utente loggato");
//			}else {
//				return ResponseEntity.ok("Password sbagliata");
//			}
//		}else {
//			return ResponseEntity.ok("Email sbagliata");
//		}
	}
	
	
	
	
	
}
