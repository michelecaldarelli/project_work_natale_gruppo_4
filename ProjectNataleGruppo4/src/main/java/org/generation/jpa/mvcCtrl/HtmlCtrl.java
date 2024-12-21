package org.generation.jpa.mvcCtrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class HtmlCtrl {
	
	@GetMapping("/homepage.html")
	public String homeRedirect() {
		return "redirect:/home";
	}
	@GetMapping("/home")
	public String homepage() {
		return "homepage";
	}
	
	@GetMapping("/pannello")
	public String pannello() {
		return "pannello";
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
		return "login";
	}

}
