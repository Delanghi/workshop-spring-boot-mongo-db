package com.dl.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {					// desta forma o compilador ñ exige que seja tratado
	private static final long serialVersionUID = 1L;
	
 // CONSTRUTOR
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}