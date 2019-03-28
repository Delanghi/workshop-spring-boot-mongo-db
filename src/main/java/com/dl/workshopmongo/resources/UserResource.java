package com.dl.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dl.workshopmongo.domain.User;
import com.dl.workshopmongo.dto.UserDTO;
import com.dl.workshopmongo.services.UserService;

@RestController															// p/ informar que é um recurso REST
@RequestMapping(value="/users")											// p/ o caminho "add ."
public class UserResource {
	
	@Autowired															// p/ INSTANCIAR CLASSE automaticamente
	private UserService service;										// associando à CLASSE UserService

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();							// p/ buscar no db de usuários e guardar nesta lista
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());				
		return ResponseEntity.ok().body(listDTO);
	}	
}