package org.generation.jpa.dtos;

import java.util.Date;

import org.generation.jpa.entities.Ruolo;

public class UtenteDto {
	private String email;
	private String password;
	
	
	
	public UtenteDto() {
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
