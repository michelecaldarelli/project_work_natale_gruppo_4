package org.generation.jpa.services;

import org.generation.jpa.entities.VeicoloEntity;
import org.springframework.stereotype.Service;

@Service
public interface VeicoloService {

	VeicoloEntity postVeicolo(String categoria, String alimentazione, String indirizzo, boolean disp);
}
