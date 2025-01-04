package org.generation.jpa.mvcCtrl;

import java.util.Map;

import org.generation.jpa.dtos.UtenteDto;
import org.generation.jpa.entities.UtenteEntity;
import org.generation.jpa.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;

//@RequestMapping("/formLoginBackend.html")
//@SessionAttributes("currentUser")
@Controller
@CrossOrigin
public class loginCtrl {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	UtenteService utenteService;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UtenteEntity utente) {
	    System.out.println(utente);
		UtenteEntity utenteTrovato = utenteService.getByEmail(utente.getEmail());
	    
	    if (utenteTrovato != null) {
	        if (utente.getPassword().equals(utenteTrovato.getPassword())) {
	            UtenteDto utenteSalvato = new UtenteDto(
	            		utenteTrovato.getUtente_id(),
	            		utenteTrovato.getNome(),
	            		utenteTrovato.getEmail(),
	            		utenteTrovato.getRuolo());
	            
	        	session.setAttribute("user", utenteSalvato);
	            return ResponseEntity.ok().body(Map.of("message", "Utente loggato"));
	        } else {
	            return ResponseEntity.badRequest().body(Map.of("message", "Password errata"));
	        }
	    } else {
	        return ResponseEntity.badRequest().body(Map.of("message", "Non esiste un account legato a questa email"));
	    }
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout() {
		session.setAttribute("user", new UtenteDto());
		return ResponseEntity.ok().body(Map.of("message", "sloggato ao"));
	}
	
	@GetMapping("/login/userData")
	public ResponseEntity<?> getUserData() {
		try {
			UtenteDto u = (UtenteDto) session.getAttribute("user");
			if (u == null) {
	            return ResponseEntity.status(404).body(Map.of("errore", "Nessun utente in sessione"));
	        }
			return ResponseEntity.ok(u);
		}
		catch (Error e){
			return ResponseEntity.badRequest().body(Map.of("errore", "ciao"));
		}
		
	}
	
	// session.getAttribute("user")
	
	
	
	
}
