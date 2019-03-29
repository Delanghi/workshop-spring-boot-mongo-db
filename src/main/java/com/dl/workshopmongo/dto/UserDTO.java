package com.dl.workshopmongo.dto;

import java.io.Serializable;

import com.dl.workshopmongo.domain.User;

public class UserDTO implements Serializable {					// p/ transformar Objetos em bytes
	private static final long serialVersionUID = 1L;			// número de versão padrão 
	
// ATRIBUTOS
	private String id;
	private String name;
	private String email;
	
 // CONSTRUTORES
	public UserDTO() {
	}
	
	public UserDTO(User obj) {									// p/ ter uma forma automatizada p/ INSTANCIAR UserDTO a partir do User
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

 // GETTERS & SETTERS
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}