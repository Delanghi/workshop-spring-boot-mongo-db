package com.dl.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dl.workshopmongo.domain.User;
import com.dl.workshopmongo.dto.UserDTO;
import com.dl.workshopmongo.services.UserService;

@RestController															// p/ informar que é um recurso REST
@RequestMapping(value="/users")											// p/ o caminho "add ."
public class UserResource {
	
	@Autowired															// p/ INSTANCIAR CLASSE automaticamente
	private UserService service;										// associando à CLASSE UserService

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {					// "ResponseEntity" p/ encapsular dados
		List<User> list = service.findAll();							// p/ buscar no db de usuários e guardar nesta lista
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());				
		return ResponseEntity.ok().body(listDTO);
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)				// MÉTODO p/ retornar um usuário a partir do ID
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {		// "@PathVariable" p/ unir ID das linhas 35 e 36
		User obj = service.findById(id);							
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)								// além do "usres" deve retornar tb o ID
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {		// "void" pq a inserção recebe um Objeto vazio
		User obj = service.fromDTO(objDTO); 								// convertemos "DTO" p/ "User"
		obj = service.insert(obj);											// aqui inserimos no db
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();	
																			// acima busca o endereço do novo objeto inserido
		return ResponseEntity.created(uri).build();							// retorna a localização do novo recurso criado
	}	
}