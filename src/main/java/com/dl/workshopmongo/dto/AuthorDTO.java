package com.dl.workshopmongo.dto;

import java.io.Serializable;

import com.dl.workshopmongo.domain.User;

public class AuthorDTO implements Serializable {			// p/ transformar dados em bytes
	private static final long serialVersionUID = 1L;		// número de versão padrão
	
// ATRIBUTOS
	private String id;
	private String name;
	
 // CONSTRUTORES
	public AuthorDTO() {
	}

	public AuthorDTO(User obj) {
		id = obj.getId();									// p/ copiar ID e Name do usuário no Objeto "AuthorDTO"
		name = obj.getName();
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
}