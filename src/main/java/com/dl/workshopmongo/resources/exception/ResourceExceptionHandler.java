package com.dl.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dl.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice													// indica que a CLASSE pode tratar possível ERRO nas requisições
public class ResourceExceptionHandler {
	
 // MÉTODOS
	@ExceptionHandler(ObjectNotFoundException.class)				// tem que ter; indica que qdo tiver este ERRO esta é a tratativa
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;					// p/ qdo o Objeto ñ foi encontrado
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}