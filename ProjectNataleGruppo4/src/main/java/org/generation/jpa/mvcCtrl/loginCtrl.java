package org.generation.jpa.mvcCtrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/formLoginBackend.html")
@SessionAttributes("currentUser")
public class loginCtrl {
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/loginpage")
	public String loginpage() {
		return "login";
	}
	
	
	
	
	
	
}
