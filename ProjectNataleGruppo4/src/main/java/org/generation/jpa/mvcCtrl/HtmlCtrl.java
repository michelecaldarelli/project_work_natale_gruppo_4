package org.generation.jpa.mvcCtrl;

import org.generation.jpa.dtos.UtenteDto;
import org.generation.jpa.entities.Ruolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class HtmlCtrl {
	
	@Autowired
	private HttpSession session;
	
	@GetMapping({"/homepage.html", "src/main/resources/templates/login.html"})
	public String homeRedirect() {
		return "redirect:/home";
	}
	@GetMapping("/home")
	public String homepage() {
		return "homepage";
	}
	
	@GetMapping("/pannello")
	public String pannello() {
		UtenteDto u = (UtenteDto) session.getAttribute("user");
		if(u != null && u.getRuolo()!= null && u.getRuolo().equals(Ruolo.ADMIN)) {
			return "pannello";
		}
		return "redirect:/errore";
	}
	@GetMapping("/pannello.html")
	public String pannelloRedirect() {
		return "redirect:/pannello";
	}
	
	@GetMapping("/pagina-veicolo")
	public String veicolo() {
		return "veicolo";
	}
	@GetMapping("/veicolo.html")
	public String veicoloRedirect() {
		return "redirect:/pagina-veicolo";
	}
	
	@GetMapping("/login.html")
	public String loginRedirect() {
		return "redirect:/login";
	}
	@GetMapping("/login")
	public String loginpage() {
		UtenteDto u = (UtenteDto) session.getAttribute("user");
		if(u != null && u.getNome() != null) {
			return "redirect:/home";
		}
		return "login";
	}
	
	@GetMapping("/errore.html")
	public String erroreRedirect() {
		return "redirect:/errore";
	}
	
	@GetMapping("/errore")
	public String errore() {
		return "errore";
	}

}