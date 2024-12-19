package org.generation.jpa.restctrl;

import org.generation.jpa.entities.VeicoloEntity;
import org.generation.jpa.services.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/veicolo")
@CrossOrigin
public class VeicoloCtrl {
	
	@Autowired
	VeicoloService veicoloService;
	
	@PostMapping("")
	public VeicoloEntity addVeicolo(@RequestBody VeicoloEntity veicolo) {
		return veicoloService.postVeicolo(veicolo);
	}
	
}
